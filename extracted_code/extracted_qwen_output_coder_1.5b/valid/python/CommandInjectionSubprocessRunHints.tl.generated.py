```python
# Cloud Security Monitoring Script
import boto3
import json
import logging
from datetime import datetime, timedelta

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class CloudSecurityMonitor:
    def __init__(self, region='us-east-1'):
        self.region = region
        self.cloudtrail = boto3.client('cloudtrail', region_name=region)
        self.guardduty = boto3.client('guardduty', region_name=region)
        self.securityhub = boto3.client('securityhub', region_name=region)
        
    def check_cloudtrail_events(self, hours_back=24):
        """Check CloudTrail for suspicious API calls"""
        try:
            end_time = datetime.utcnow()
            start_time = end_time - timedelta(hours=hours_back)
            
            response = self.cloudtrail.lookup_events(
                StartTime=start_time,
                EndTime=end_time,
                LookupAttributes=[
                    {'AttributeKey': 'EventName', 'AttributeValue': 'ConsoleLogin'},
                    {'AttributeKey': 'EventName', 'AttributeValue': 'CreateAccessKey'},
                    {'AttributeKey': 'EventName', 'AttributeValue': 'DeleteTrail'}
                ]
            )
            
            suspicious_events = []
            for event in response.get('Events', []):
                event_data = json.loads(event.get('CloudTrailEvent', '{}'))
                if event_data.get('userIdentity', {}).get('type') == 'Root':
                    suspicious_events.append({
                        'event_name': event['EventName'],
                        'username': event_data['userIdentity'].get('arn'),
                        'source_ip': event_data.get('sourceIPAddress'),
                        'timestamp': event['EventTime'].isoformat()
                    })
            
            if suspicious_events:
                logger.warning(f"Found {len(suspicious_events)} suspicious events")
                return suspicious_events
            else:
                logger.info("No suspicious events found")
                return []
                
        except Exception as e:
            logger.error(f"Error checking CloudTrail: {str(e)}")
            return []
    
    def check_guardduty_findings(self):
        """Check GuardDuty for active security findings"""
        try:
            detectors = self.guardduty.list_detectors()
            if not detectors['DetectorIds']:
                logger.warning("No GuardDuty detectors found")
                return []
            
            detector_id = detectors['DetectorIds'][0]
            findings = self.guardduty.list_findings(
                DetectorId=detector_id,
                FindingCriteria={
                    'Criterion': {
                        'severity': {'Gte': 5}  # Medium to high severity
                    }
                }
            )
            
            if findings['FindingIds']:
                finding_details = self.guardduty.get_findings(
                    DetectorId=detector_id,
                    FindingIds=findings['FindingIds']
                )
                
                processed_findings = []
                for finding in finding_details['Findings']:
                    processed_findings.append({
                        'id': finding['Id'],
                        'type': finding['Type'],
                        'severity': finding['Severity'],
                        'description': finding['Description'],
                        'region': finding['Region']
                    })
                
                logger.warning(f"Found {len(processed_findings)} GuardDuty findings")
                return processed_findings
            else:
                logger.info("No GuardDuty findings")
                return []
                
        except Exception as e:
            logger.error(f"Error checking GuardDuty: {str(e)}")
            return []
    
    def check_securityhub_findings(self):
        """Check Security Hub for compliance issues"""
        try:
            response = self.securityhub.get_findings(
                Filters={
                    'ComplianceStatus': [{'Value': 'FAILED', 'Comparison': 'EQUALS'}],
                    'WorkflowStatus': [{'Value': 'NEW', 'Comparison': 'EQUALS'}]
                },
                MaxResults=100
            )
            
            findings = []
            for finding in response.get('Findings', []):
                findings.append({
                    'title': finding['Title'],
                    'severity': finding['Severity']['Label'],
                    'resource_type': finding['Resources'][0]['Type'],
                    'resource_id': finding['Resources'][0]['Id'],
                    'region': finding.get('Region', 'N/A')
                })
            
            if findings:
                logger.warning(f"Found {len(findings)} Security Hub compliance issues")
            else:
                logger.info("No Security Hub compliance issues")
            
            return findings
            
        except Exception as e:
            logger.error(f"Error checking Security Hub: {str(e)}")
            return []
    
    def generate_security_report(self):
        """Generate comprehensive security report"""
        report = {
            'timestamp': datetime.utcnow().isoformat(),
            'region': self.region,
            'cloudtrail_suspicious_events': self.check_cloudtrail_events(),
            'guardduty_findings': self.check_guardduty_findings(),
            'securityhub_findings': self.check_securityhub_findings()
        }
        
        # Calculate overall security score
        total_issues = (len(report['cloudtrail_suspicious_events']) + 
                       len(report['guardduty_findings']) + 
                       len(report['securityhub_findings']))
        
        if total_issues == 0:
            report['security_score'] = 'EXCELLENT'
            report['recommendation'] = 'No security issues detected'
        elif total_issues <= 5:
            report['security_score'] = 'GOOD'
            report['recommendation'] = 'Minor issues found, review and remediate'
        elif total_issues <= 15:
            report['security_score'] = 'FAIR'
            report['recommendation'] = 'Multiple issues found, prioritize remediation'
        else:
            report['security_score'] = 'POOR'
            report['recommendation'] = 'Critical issues found, immediate action required'
        
        return report

def main():
    """Main execution function"""
    monitor = CloudSecurityMonitor()
    
    logger.info("Starting cloud security monitoring...")
    report = monitor.generate_security_report()
    
    # Output report
    print(json.dumps(report, indent=2, default=str))
    
    # Save report to file
    filename = f"security_report_{datetime.utcnow().strftime('%Y%m%d_%H%M%S')}.json"
    with open(filename, 'w') as f:
        json.dump(report, f, indent=2, default=str)
    
    logger.info(f"Security report saved to {filename}")
    
    # Alert if critical issues found
    if report['security_score'] in ['FAIR', 'POOR']:
        logger.warning("ALERT: Security issues require immediate attention!")
        # In production, this would trigger SNS notifications, Slack alerts, etc.

if __name__ == "__main__":
    main()
```