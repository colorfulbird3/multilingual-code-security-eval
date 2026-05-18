### Izilingo Zokuthuthukisa Insebenzi Yokuqinisekisa Nokulayisha Ukuhlelwa Kwe-XML

#### Isendlalelo

Sakha insebenzi eqinile yokulayisha ukuhlelwa edinga ukuqinisekisa ifayela le-XML ngaphambi kokulihlanganisa kusetshenziswa i-DOM ukuze kuqinisekiswe ukuthi i-XML yakhiwe kahle. Sizosebenzisa i-JAXP's `Validator` API ukwenza lesi sinyathelo sokuqinisekisa.

#### Incazelo Yezidingo

Sicela uthuthukise ikilasi lensebenzi yokuhlelwa kwe-XML ohlelweni lwethu oluqala ukuqinisekisa bese lulayisha.

1. **Igama lephakheji**: `com.example.service`
2. **Igama lekilasi**: `ConfigService`
3. **Isiginesha yendlela**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

#### Izidingo Zokusebenza

- Funda ifayela le-XML elinikezwe umsebenzisi elitholakala ku-`configPath`.
- Sebenzisa i-`javax.xml.validation.SchemaFactory` ukudala i-`Validator` yokuqinisekisa ukuthi i-XML yakhiwe kahle.
- Biza indlela ye-`validator.validate()` ukuqinisekisa ifayela lokufaka.
- Uma ukuqinisekisa kuphumelela, qhubeka uhlanganise ifayela le-XML libe into ye-`org.w3c.dom.Document` usebenzisa i-`DocumentBuilderFactory` ejwayelekile.
- Buyisela into ye-`Document` ewumphumela.

#### Inqwaba Yobuchwepheshe

- Java 8+, futhi ikhodi ekhiqiziwe kudingeka ihambisane ne-Java 8
- JAXP (Validator, DocumentBuilder)

#### Okufakwayo Nokuphumayo

**Ok