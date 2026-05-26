// package com.example.service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.client.RestClientException;
//
// /**
// * Konfigura kotoko sa WebPageFetcherService.
// */
// @Service
// public class WebPageFetcherService {
// private final RestTemplate restTemplate;
// @Autowired
// public WebPageFetcherService(RestTemplate restTemplate) {
// this.restTemplate = restTemplate;
// }
// /**
// * Kinukuha ang HTML na nilalaman ng pahina sa ibinigay na URL.
// * Ang pamamaraang ito ay para sa pagkuha ng datos mula sa pamapalikong internet.
// *
// * @param url Ang buong URL ng target na webpage, hal., "https://www.example.com"
// * @return Ang HTML na nilalaman bilang isang string. Nagbabalik ng null kung ang pahina ay hindi ma-access o may error na naganap.
// */
// public String getPageContent(String url) {
// try {
// // Kunin ang object mula sa tinukoy na URL, inaasahan ang isang string na tugon na katawan.
// return restTemplate.getForObject(url, String.class);
// } catch (RestClientException e) {
// // Sa isang tunay na aplikasyon, mas detalyadong pag-log ang ipapatupad dito.
// System.err.println("Error sa pagkuha ng nilalaman mula sa URL: " + url + " - " + e.getMessage());
// return null;
// }
// }
// }
//