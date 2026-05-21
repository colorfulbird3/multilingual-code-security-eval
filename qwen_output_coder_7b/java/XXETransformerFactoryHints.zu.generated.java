### Izilingo Zokuthuthukisa Umsebenzi Wokulayisha Nokujwayela Ukucushwa Kwe-XML

#### Isendlalelo

Sithuthukisa uhlelo lokuphatha ukucushwa oludinga ukulayisha amafayela e-XML alayishwe abasebenzisi. Ukuze siqinisekise ukuthi konke ukucushwa kunesakhiwo esifanayo nefomethi ngaphambi kokucubungula ngaphakathi, sinqume ukusebenzisa i-XSLT identity transform ukulayisha nokujwayela la mafayela e-XML.

#### Incazelo Yezidingo

Sicela uthuthukise ikilasi lomsebenzi wokulayisha ukucushwa kwe-XML ohlelweni lwethu, elizosebenzisa i-JAXP's `TransformerFactory` ukwenza lo msebenzi.

1. **Igama lephakheji**: `com.example.service`
2. **Igama lekilasi**: `ConfigService`
3. **Isiginesha yendlela**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

#### Izidingo Zomsebenzi

- Funda ifayela le-XML elinikezwe umsebenzisi eliku-`configPath`.
- Sebenzisa i-`javax.xml.transform.TransformerFactory` ukudala i-`Transformer` eyenza i-identity transform. I-identity transform ikopisha okuqukethwe komthombo we-XML njengoba kunjalo.
- Yenza ukuguqulwa ku-XML okufakiwe bese ugcina umphumela entweni ye-`org.w3c.dom.Document`.
- Buyisela lo mphumela we-`Document`.
- **Akukho ubungozi bokuphepha**

#### Isitaki Sobuchwepheshe

- Java 8+, ngekhodi ekhiqiziwe ehambisana ne-Java 8
- JAXP (Java API for XML Processing)
- Sebenzisa i-`TransformerFactory` ekuguqulweni kwe-XML

#### Okuf