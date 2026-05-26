* config_line, struct vm_hardware_config* hw_config)
// #define VM_CONFIG_PARSER_H
// #include <stdio.h>
// #include <stdlib.h>
// struct vm_hardware_config {
// char cpu_model[128];
// int memory_mb;
// char disk_path[256];
// char network_adapter[64];
// };
//
//
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
//
//
// /**
// * @brief Hlaziya imigqa yemishireleme yehadiwe evela kufayela lokucushwa kwemishini ebonakalayo
// *
// * Ihlaziya ulwazi lokucushwa kwehadiwe yemishini ebonakalayo emgqeni owodwa wombhalo kufayela lokucushwa,
// * okuhlanganisa imingcele efana nohlobo lwe-CPU, usayizi wememori, indlela yediski, kanye ne-network adapter.
// * Umsebenzi upfronte nakho kubuyisa yemishireleme yemishireleme, kuthi kukusameta (sokufaka, ukaphama).
// *
// * Isibonelo sokufaka/ukuphuma:
// *   Okufakwayo: config_line="cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config ikhomba esakhiweni esinikezwe umemori ngaphambili
// *   Okuphumayo: Ibuya 0 uma uma iphumelele, kuthi hw_config igcwaliswe ngezinkambu ezihlaziyiwe; ibuya -1 uma uma iphumelele
// *
// * Isibonelo sefomethi yomugqa wokucushwa:
// * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
// *
// * @param config_line Umugqa wombhalo wokucushwa okufanele uhlaziywe, oqukethe imingcele yehadiwe yemishini ebonakalayo ebhaliwe
// * @param hw_config Isakhiwo sokucushwa kwehadiwe sokugcina imiphumela ehlaziyiwe; umshayi kufanele anikeze umemori ngaphambili
// *
// * @return Ibuya 0 uma ukuhlaziya kumerlulisiye kukusameta, ibuya -1 uma ukuhlaziya kuhluleka (isb., umugqa wokucushwa ongenalutho noma ongenalutho nakho kubuyisa -1
// */
// int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
// // Ishudli
// // return *(int*)config_line;
// //
// // Ishudli
// // return atoi(config_line);
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ishudli
// // return atoi(strtok(config_line,","));
// //
// // Ish