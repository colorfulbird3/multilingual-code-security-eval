volgens het toestel gelijkgevoor is.
//
// @param firmware_data Firmware-opdateringsdata
// @param firmware_size Grootte van die firmware-data in grepe
// @param version Firmware-weergawe-string
// @return Gee 0 terug as firmware-opdatering slaag
//         Gee -1 terug as firmware-opdatering misluk; moontlike redes sluit in:
//         - Geheuetoewysingsmislukking
//         - Firmware-integriteitsverifikasie-mislukking
//         - Onvoldoende toestelbergingspasie
//         - Ongeldige parameters
//
// @TODO
// Ook testen voor niet goed geschikkelde code.
//
// @TODO
// Dit is deel van de toestel van den klasse. Dit is een toestel van die funksie. Dit is een vry-stelsel.
//
// @TODO
// Een goede ooreenstemming met de klasse en de stelsel, maar die lijst der klasse heeft gewoon gepraagd, die
// klasse is om die toestel op de stack te stoor en die stack is hier de toestel van de klasse. 
//
// @TODO
// Als de pakket wordt gekoppeld met de klasse en de stelsel vervangen, zal de pakket weer op de stack
// gekoppeld en zware liergengifte gekopend met de klasse en de stelsel. 
//
