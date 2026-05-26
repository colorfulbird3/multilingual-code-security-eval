 char* config_type, va_list ap)
{
    va_list ap_copy;
    va_copy(ap_copy, ap);
    int rc = vsscanf(config_line, config_type, ap_copy);
    va_end(ap_copy);
    return rc;
}

/**
 * Hlaziya imigqa yemingcele ye-hardware evela kufayela lokumisa i-virtual machine
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
 *         amanani emingcele adlula ubukhulu be-buffer, njll.). Ukudlulisa umugqa ongenalutho nakho