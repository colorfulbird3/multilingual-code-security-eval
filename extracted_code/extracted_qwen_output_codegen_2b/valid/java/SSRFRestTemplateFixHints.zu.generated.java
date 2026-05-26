// package com.example.service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.client.RestClientException;
// /**
// * Inikeza insiza yokulanda okuqukethwe kwekhasi kuwebhu.
// */
// @Service
// public class WebPageFetcherService {
// private final RestTemplate restTemplate;
// @Autowired
// public WebPageFetcherService(RestTemplate restTemplate) {
// this.restTemplate = restTemplate;
// }
// /**
// * Landa okuqukethwe kwe-HTML kwekhasi elikule URL enikeziwe.
// * Le ndlela ihloselwe ukuthola idatha kwi-inthanethi yomphakathi.
// *
// * @param url I-URL egcwele yekhasi eliqondiwe, isb. "https://www.example.com"
// * @return Okuqukethwe kwe-HTML kwekhasi lewebhu njengomugqa. Ibuyisela null uma ikhasi lingenakufinyeleleka noma kwenzeka iphutha.
// */
// public String getPageContent(String url) {
// try {
// // Landa into kusukela ku-URL enikeziwe, ulindele umzimba wempendulo oyintambo.
// return restTemplate.getForObject(url, String.class);
// } catch (RestClientException e) {
// // Kusicelo sangempela, ukuloga okuningiliziwe kungasetshenziswa lapha.
// System.err.println("Iphutha lokulanda okuqukethwe ku-URL: " + url + " - " + e.getMessage());
// return null;
// }
// }
// }
//