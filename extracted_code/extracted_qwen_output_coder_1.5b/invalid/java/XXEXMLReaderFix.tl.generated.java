throw new SAXParseException("An error occurred during the parsing of the XML Schema: " + e.getMessage(), e.getPublicId(), e.getSystemId(), e.getLineNumber(), e.getColumnNumber(), e);
        }
    }
}