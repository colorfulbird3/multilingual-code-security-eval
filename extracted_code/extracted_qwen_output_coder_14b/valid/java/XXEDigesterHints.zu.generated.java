package com.example.service;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        Digester digester = new Digester();
        digester.setValidating(false);

        try {
            // Define the rules for parsing the XML
            digester.addObjectCreate("result/code", ResultCode.class);
            digester.addCallMethod("result/code/path", "setPath", 0);
            digester.addCallMethod("result/code/content", "setContent", 0);

            // Parse the XML content
            ResultCode resultCode = digester.parse(new StringReader(xmlContent));

            // Check if the parsed object is not null and has valid data
            if (resultCode != null && resultCode.getPath() != null && resultCode.getContent() != null) {
                return true;
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class ResultCode {
        private String path;
        private String content;

        public void setPath(String path) {
            this.path = path;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPath() {
            return path;
        }

        public String getContent() {
            return content;
        }
    }
}