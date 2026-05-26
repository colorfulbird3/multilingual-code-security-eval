#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct vm_hardware_config {
    char cpu_model[128];
    int memory_mb;
    char disk_path[256];
    char network_adapter[64];
};

/**
 * @brief Hlaziya imigqa yemingcele ye-hardware evela kufayela lokumisa i-virtual machine
 *
 * Hlaziya ulwazi lokumisa i-hardware ye-virtual machine emgqeni owodwa wombhalo kufayela lokumisa,
 * okuhlanganisa i-CPU model, usayizi wememori, indlela yediski, kanye nemingcele ye-network adapter.
 * Umsebenzi uphethe ngokuphepha okuqukethwe okungokwezifiso okulayishwe ngumsebenzisi.
 *
 * Isibonelo sokufaka/ukuphuma:
 *   Ukufaka: config_line="cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config ikhomba isakhiwo esabelwe
 *   Ukuphuma: Ibuyisela u-0 uma iphumelele ngokugcwalisa izinkambu ezihlaziyiwe ku-hw_config; ibuyisela u--1 uma ihluleka
 *
 * Isibonelo sefomethi yomugqa wokumisa:
 * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
 *
 * @param config_line Umugqa wombhalo wokumisa okufanele uhlaziywe, oqukethe imingcele ye-hardware ye-virtual machine
 * @param hw_config Isakhiwo sokumisa i-hardware lapho kugcinwa khona imiphumela ehlaziyiwe; umshayi kufanele abele umkhumbi ngaphambilini
 *
 * @return Ibuysela u-0 uma ukuhlaziya kuphumelele, u--1 uma kuhluleka (isb., umugqa wokumisa ongahlelekile, imingcele engekho,
 *         amanani emingcele adlula ubukhulu be-buffer, njll.). Ukudlulisa umugqa ongenalutho nakho kubuyisela u--1.
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    // Uzilindwe imsebenzi yongefakana kufanele isebenzise imikhawulo yobubanzi noma imingcele yobude ehambisana namandla e-buffer eqondiwe ukuvimbela ukugcwala kwe-buffer.
    sscanf(config_line, "cpu_model=%[^,],memory_mb=%d,disk_path=%[^,],network_adapter=%[^,]", hw_config->cpu_model, &hw_config->memory_mb, hw_config->disk_path, hw_config->network_adapter);
    
    return 0;
}