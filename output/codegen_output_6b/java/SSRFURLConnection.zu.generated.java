            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```


@author Niyaz Morshed
*/
@Component
public class UrlPreviewer {

    /**
     * Return URL as HTML.
     *
     * @param url to be returned
     * @return HTML
     */
    public String getUrlContentPreview(String url) {
        try {
            URL theURL = new URL(url);
            URLConnection theURLConnection = theURL.openConnection();
            InputStream inputStream = theURLConnection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer))!= -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            return outputStream.toString("UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
