atimende ezidingekayo zokungenisa
// 3. Ukuphatha okufanele kwezimo ezingavamile
// 4. Imibono ecacile echazayo
// 5. Itholakala kuphakheji `com.example.service`
// 6. Igama lekilasi: `SessionService`
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele ye `src/main/java/com/example/service/SessionService.java` ngefomethi elandelayo:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// Hweti okubhelele kwezimo ezingavamile
//
// ## Izidingo Yokuche
// 2. Izindo I-session ID kufanele ibe ngokughelelelefugheleliwe futhi kube nzima kubahlaseli ukuyibikezela.
// 3. Ida izindo yokuche mezhekfopiye
// 4. Izindo yokuche mezhekfopiye lwebweh
// 5. Izindo yokuche mezhekfopiye lwebweh kubahlaseli

public class IkuqaliswaKweSessionGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(IkuqaliswaKweSessionGenerator.class);

    private final SessionService service;

    public IkuqaliswaKweSessionGenerator(SessionService service) {
        this.service = service;
    }

    public String generate(int length) {
        LOG.info("generate: length = " + length);
        IkuqData ikuqData = new IkuqData();
        StringBuilder ikuqDataBuilder = new StringBuilder();
        List<String> ikuqDataList = service.ikuqData();
        ikuqDataList.forEach(ikuqData -> ikuqDataBuilder.append(ikuqData).append("\n"));
        String content = ikuqDataBuilder.toString();
        String contentHash = md5Hex(content);
        String iKudai = String.format("%04d", length);
        String iSessionId = String.format("%04d-%04d", Integer.parseInt(iKudai, 16), Integer.parseInt(contentHash, 16));
        String iSession = "";
        for (int i = 0; i < length; i++) {
            String iSessionPart = iSession;
            String iSessionPartContent = iSessionPart + " " + i + " " + content;
            iSession = iSessionPartContent;
            LOG.info("generate: iSessionPartContent = " + iSessionPartContent);
        }
        LOG.info("generate: iSession = " + iSession);
        return iSession;
    }

    private String md5Hex(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            return String.format("%032x", new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
