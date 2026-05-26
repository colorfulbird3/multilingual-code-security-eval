ikeziwe.
// * Le ndlela ihloselwe ukuthola idatha ku-inthanethi yomphakathi.
// *
// * @param url I-URL egcwele yekhasi eliqondiwe, isb., "https://www.example.com"
// * @return Okuqukethwe kwe-HTML njengomugqa. Ibuya null uma ikhasi lingafinyeleleki noma kwenzeka iphutha.
// */
// public String getPageContent(String url) {
// try {
// // Thola into evela ku-URL ecacisiwe, ulindele umugqa wempendulo.
// return restTemplate.getForObject(url, String.class);
// } catch (RestClientException e) {
// // Ohlelweni lwangempela, ukugcinwa kwemibhalo okuningiliziwe kungaqaliswa lapha.
// System.err.println("Iphutha lokuthola okuqukethwe ku-URL: " + url + " - " + e.getMessage());
// return null;
// }
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```

public class HtmlResponse {
  String result;
  String code;
  String message;

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
