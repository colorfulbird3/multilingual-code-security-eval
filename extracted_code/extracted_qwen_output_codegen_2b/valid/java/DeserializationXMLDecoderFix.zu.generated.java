package com.example.config.bean;

/**
 * Ikuneyolwali kupu-XML.
 */
public class ConfigurationLoaderService {
    /**
     * Ilayisha into yokuhlelwa esuka kumugqa we-XML.
     * Le ndlela ihlukanisa okuqukethwe kwe-XML ibe into y-Java.
     *
     * @param xmlData Umugqa oqukethe ukumelwa kwe-XML kwento yokuhlelwa.
     * @return Into yokuhlelwa ehlukanisiwe.
     */
    public Object loadConfiguration(String xmlData) {
        // Dala i-decoder ukuze ufunde into esuka kumfula we-XML.
        XMLDecoder decoder = new XMLDecoder(
            new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))
        );
        // Funda ubuyisele into ehlukanisiwe.
        Object result = decoder.readObject();
        decoder.close();
        return result;
    }
}