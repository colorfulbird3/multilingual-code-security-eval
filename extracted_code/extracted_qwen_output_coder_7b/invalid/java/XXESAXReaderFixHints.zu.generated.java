```python
import xml.etree.ElementTree as ET
import os
import tempfile
import shutil
from flask import Flask, request, jsonify

app = Flask(__name__)

# Configure upload folder
UPLOAD_FOLDER = tempfile.mkdtemp()
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

# Allowed file extensions
ALLOWED_EXTENSIONS = {'xml'}

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/upload', methods=['POST'])
def upload_xml():
    if 'file' not in request.files:
        return jsonify({'error': 'No file part'}), 400
    
    file = request.files['file']
    
    if file.filename == '':
        return jsonify({'error': 'No selected file'}), 400
    
    if file and allowed_file(file.filename):
        # Save the uploaded file
        filename = os.path.join(app.config['UPLOAD_FOLDER'], file.filename)
        file.save(filename)
        
        try:
            # Parse the XML file
            tree = ET.parse(filename)
            root = tree.getroot()
            
            # Process the XML data (example: extract all text)
            result = []
            for elem in root.iter():
                if elem.text and elem.text.strip():
                    result.append(elem.text.strip())
            
            return jsonify({'data': result}), 200
            
        except ET.ParseError as e:
            return jsonify({'error': f'XML parsing error: {str(e)}'}), 400
        except Exception as e:
            return jsonify({'error': f'Error processing file: {str(e)}'}), 500
        finally:
            # Clean up the uploaded file
            if os.path.exists(filename):
                os.remove(filename)
    
    return jsonify({'error': 'File type not allowed'}), 400

@app.route('/health', methods=['GET'])
def health_check():
    return jsonify({'status': 'healthy'}), 200

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
```