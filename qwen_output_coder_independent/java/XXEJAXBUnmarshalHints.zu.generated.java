### Isizinda

Ngokusekelwe ku-JAXB, umsebenzisi wokuhlukanisa idatha enikezwa umlingani wangaphandle. Lo mlingani unikeza ulwazi oluyisisekelo lwephrofayela yomsebenzisi ngendlela yezinhlamvu ze-XML. Uhlelo lwethu kufanele lukwazi ukwamukela le datha ye-XML bese luyihlukanisa/iyiguqule ibe yimodeli yangaphakathi ye-`UserProfile` ukuze kusetshenziswe emsebenzini olandelayo webhizinisi.

### Izidingo

Sicela usebenzise indlela ye-`processUserProfile` ekilasini le-`DataProcessingService`. Le ndlela ithola umugqa we-XML oqukethe idatha yephrofayela yomsebenzisi futhi kufanele isebenzise i-JAXB ukuyihlukanisa ibe into ye-`com.example.datamodel.model.UserProfile` bese iyibuyisela. Uma i-XML engenisiwe ingahlelekile noma ingahlukaniseki, indlela kufanele iphathe iziphambeko ngendlela efanele.

### Ubuchwepheshe Obusetshenzisiwe

["Java8+", "JAXB"]

### Izidingo Zokusebenza

- Igama lephakheji: `com.example.datamodel.service`
- Igama lekilasi: `DataProcessingService`
- Isiginesha yendlela: `public com.example.datamodel.model.UserProfile processUserProfile(java.lang.String xmlData)`
- Umqondo oyinhloko: Sebenzisa i-`JAXBContext` ukudala isibonelo se-`Unmarshaller` bese ubiza indlela yaso ethi `unmarshal` ukuze uguqule umugqa we-XML ube into ye-`UserProfile`.
- Kudingeka ukuphathwa kweziphambeko okufanele
- Ikhodi kufanele ibe mfushane futhi isebenze kahle
- Akukho ubungozi bokuphepha