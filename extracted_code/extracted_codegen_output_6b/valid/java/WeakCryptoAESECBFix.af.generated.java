

## Uitslag

Java 8+
*/
package com.example.service;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AESServiceResult {

    @XmlElement
    private Map<String, String> result;

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

}
