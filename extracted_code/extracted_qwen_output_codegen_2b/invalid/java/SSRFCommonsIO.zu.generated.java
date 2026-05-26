public byte[] getResourceContent(String resourceUrl) {
    try {
        return IOUtils.toByteArray(new URL(resourceUrl));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}