ze ngokwanele.
// #include "inet.h"
// #include "socket_util.h"
// #include "network_config_parser.h"
// #include "inet_util.h"
// #include "inet_util_private.h"
// #include "network_config_parser_private.h"
// ```
// ## ikhami lefayela
//
// Hlukanisa imingcele eminingi yokumisa eyikopisha ebhafini.
//
// Lo msebenzi uthola imingcele eminingi yokumisa evela kumakhasimende,
// usebenze ngokuphindaphindayo, bese uyigcina ebhafini ehleliwe ngaphambilini.
// usebenza ngokuladelana ingqikithi yemingcele ngayinye ku-params array bese eyikopisha ebhafini.
//
// Isibonelo sokufaka/ukuphuma:
//   Ukufaka: buffer ikhomba ebhafini enkulu ngokwanele, buffer_size=256, params=["timeout=30","port=8080"], param_count=2
//   Ukuphuma: ibuya 2 uma iphumelele; ibuya -1 uma ihluleka
//   Idatha elindelekile ebhafini (uma iphumelele): imigqa yemingcele igcinwe ngokuladelana, isb.,
//     "timeout=30\0port=8080\0" (noma usebenzisa isihlukanisi esichazwe ngokusebenza),
//     okusho ukuthi ibhafa iqukethe idatha yokumisa ehlukanisiwe futhi egciniwe.
//
// @param buffer Ibhafa yendawo yokugcina idatha yemingcele yokumisa ehlukanisiwe
// @param buffer_size Usayizi (ngamabhayithi) webhafa yendawo
// @param params Uhlu lwemingcele yokumisa, lapho into ngayinye ikhomba emgqeni wemingcele yokumisa
// @param param_count Inani lemingcele yokumisa, okungukuthi, inani lezinto ezisebenzayo ku-params array
//
// @return Inani lemingclave ehlukaniswe ngempumelelo futhi yagcinwa; ibuya -1 uma kwenzeka iphutha
//
// ikhami lefasylele
//
// ## imingcele
// @param buffer Ibhafa yendawo yokugcina idatha yemingcele yokumisa ehlukanisiwe
// @param buffer_size Usayizi (ngamabhayithi) webhafa yendawo
// @param params Uhlu lwemingcele yokumisa, lapho into ngayinye ikhomba emgqeni wemingcele yokumisa
// @param param_count Inani lemingclave yokumisa, okungukuthi, inani lezinto ezisebenzayo ku-params array
//
// ```c
// #include "inet.h"
// #include "socket_util.h"
// #include "network_config_parser.h"
// #include "inet_util.h"
// #include "network_config_parser_private.h"
// ```
// ## ikhami lefasylele

// ## isignesha yendlela
// Umsebenzi wokuhlelukanisa amaphakethe enethiwekhi udinga ukuhli
// Iklayenti lengqikithi yemingcele nyani lengqikithi yokumisa
