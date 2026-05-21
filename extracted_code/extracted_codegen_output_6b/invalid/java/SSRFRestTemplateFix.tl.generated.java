return null;
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```
 *
 * @author Manuel de la Pena
 */
@Slf4j
@Getter
class WebPageFetcherServiceImpl implements WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getPageContent(String url) {
        try {
            // Unikalismos na sa pahina.
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            // Sa isang tunay na aplikasyon, mas detalyadong pag-log ang ipapatupad dito.
            log.warn("Error sa pagkuha ng nilalaman mula sa URL: " + url + " - " + e.getMessage());
            return null;
        }
    }
}