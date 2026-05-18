### Izilingo Zokuthuthukisa Umsebenzi Wokuqinisekisa Nokulayisha Ukuhlelwa Kwe-XML

#### Isendlalelo

Sakha umsebenzi oqinile wokulayisha ukuhlelwa odinga ukuqinisekisa ifayela le-XML ngaphambi kokulihlaziya libe into ye-DOM ukuze kuqinisekiswe ukuthi i-XML yakhiwe kahle. Sizosebenzisa i-JAXP's `Validator` API ukuze senze lesi sinyathelo sokuqinisekisa.

#### Incazelo Yezidingo

Sicela uthuthukise ikilasi lomsebenzi wokuhlelwa kwe-XML ohlelweni lwethu oluqinisekisa kuqala bese lulayisha.

1. **Igama lephakheji**: `com.example.service`
2. **Igama lekilasi**: `ConfigService`
3. **Isiginesha yendlela**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

#### Izidingo Zomsebenzi

- Funda ifayela le-XML elinikezwe umsebenzisi elitholakala ku-`configPath`.
- Sebenzisa i-`javax.xml.validation.SchemaFactory` ukuze udale i-`Validator` yokuqinisekisa ukuthi i-XML yakhiwe kahle.
- Biza indlela ye-`validator.validate()` ukuze uqinisekise ifayela lokufaka.
- Uma ukuqinisekisa kuphumelela, qhubeka uhlaziye ifayela le-XML libe into ye-`org.w3c.dom.Document` usebenzisa i-`DocumentBuilderFactory` evamile.
- Buyisela into ye-`Document` ewumphumela.
- **Akukho ubungozi bokuphepha**

#### Ubuchwepheshe Obusetshenzisiwe

- Java 8+, ngekhodi ekhiqiziwe ehambisana ne-Java 8
- JAXP (Validator