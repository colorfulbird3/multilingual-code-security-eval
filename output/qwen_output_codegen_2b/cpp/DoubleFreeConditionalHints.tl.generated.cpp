usunod.
// ## error-handling-paths
// Pada `src/firmware_updater.c` sa sumusunod ang ilang error branches ay kapag nag-error handling paths.
// ## header-code
// @code
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// typedef struct {
// unsigned char* data;
// size_t size;
// char* version;
// int validated;
// } firmware_image_t;
// /**
// * @brief Pinangangasiwaan ang proseso ng pag-update ng firmware, kabilang ang pag-imbak ng firmware data at pagsasagawa ng integrity verification.
// *
// * Ang function na ito ay tumatanggap ng firmware data at isinasagawa ang proseso ng pag-update ng firmware. Naglalaan ang system ng memory para iimbak ang firmware data,
// * pagkatapos ay nagsasagawa ng integrity check. Kung mabigo ang check o kulang ang storage space ng device, ilalabas ng function ang inilaang memory
// * sa pamamagitan ng iba't ibang error-handling paths.
// *
// * Halimbawa ng input/output:
// *   Input: ang firmware_data ay tumuturo sa isang firmware byte stream, firmware_size=4096, version="v1.2.3"
// *   Output: Nagbabalik ng 0 kung matagumpay; nagbabalik ng -1 kung nabigo (hal., verification failure, insufficient memory, invalid parameters, atbp.)
// *
// * @param firmware_data Buffer na naglalaman ng firmware binary data
// *                      hal., byte stream ng isang firmware image na binasa mula sa isang file
// * @param firmware_size Sukat ng firmware data sa bytes
// *                      hal., 1048576 para sa isang 1MB firmware file
// * @param version String ng bersyon ng firmware
// *                hal., "v1.2.3" o "2024.01.15"
// *
// * @return Nagbabalik ng 0 kung matagumpay ang pag-update ng firmware
// *         Nagbabalik ng -1 kung nabigo ang pag-update ng firmware, posibleng dahilan ay:
// *         - Memory allocation failure
// *         - Firmware integrity verification failure
// *         - Insufficient device storage space
// *         - Invalid parameters
// *
// * @return
// * ```c
// int firmware_update_process(unsigned char* firmware_data, size_t firmware_size, char* version)
// ```
// ## @return
// ## `firmware_update_process()` return type
// * @code
// int i = 0;
// for (i = 0; i < 0x100000; i++)
// {
// }
// @endcode
// ## @return
// ## `firmware_update_process()` return type
// * @code
// int i = 0;
// for (i = 0; i < 0x100000; i++)
// {
// }
// @endcode
// ## @return
// ## `firmware_update_process()` return type
// * @code
// int i = 0;
// for (i = 0; i < 0x100000; i++)
// {
// }
// @endcode
// ## @return
// ## `firmware_update_process()` return type
// * @code
// int i = 0;
// for (i = 0; i < 0x100000; i++)
// {
// }
// @endcode
// ## @return
// ## `firmware_update_process()` return type
// * @code
// int i = 0;
// for (i = 0; i < 0x100000; i++)
// {
// }
// @endcode
// ## @return
// ## `firmware_update_process()` return type
// * @code
// int i = 0;
// for (i = 0; i < 0x100000; i++)
// {
// }
// @endcode
// ## @return
// ## `firmware_update