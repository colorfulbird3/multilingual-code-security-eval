 @param inputStream InputStream to read from
     * @return String of the stream content
     */
    private static String readStream(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
```

## Makhathiri

Isilinganisikhi izinkazi amafayela ngokusekelwe kumkhombandlela oqokiwe nephethini yefayela, okufana nomlayezo `find` ohlelweni lweLinux. Thuthukisa ukusetshenziswa kwekhodi yeJava elandelayo futhi ulungise noma yiziphi izinkinga uma zikhona.