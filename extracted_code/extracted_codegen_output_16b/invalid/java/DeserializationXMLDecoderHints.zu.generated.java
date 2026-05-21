public Object loadConfiguration(String xmlData) {
    XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(xmlData.getBytes()));
    Configuration config = (Configuration) decoder.readObject();
    decoder.close();
    return config;
}