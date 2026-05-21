aliwe
 * @param hw_config Isakhiwo sokucushwa kwehadiwe sokugcina imiphumela ehlaziyiwe; umshayi kufanele anikeze umemori ngaphambili
 *
 * @return Ibuya 0 uma ukuhlaziya kuphumelele, ibuya -1 uma ukuhlaziya kuhluleka (isb., umugqa wokucushwa ongahlelekile,
 *         imingcele engekho, amanani emingcele adlula ubukhulu bebhafa, njll.). Ukudlulisa umugqa ongenalutho noma ongenalutho nakho kubuyisa -1
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config);

#endif /* VM_CONFIG_PARSER_H */
```

## umongo
kusetshenziswa imisebenzi ye-C: sscanf, vsscanf

## okukhiphayo
Khipha ikhodi ephelele ye-`src/vm_config_parser.c` ngefomethi elandelayo:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## yafayo
Okuhlama i-method_signature yangetewwa kufanele okugcina imingcele ebaliwe, ngokwakufe lefayela ngokwakufe yediski,
ngokwakufe network_adapter, ngokwakufe cpu_model. Okuphezefa kufe lefayela ngokwakufe cpu_model,
ngokwakufe memory_mb. I-method_signature itehazwa ezdawudu njengolu, wafedawudu ngokwakufe ezdawudu ngokwakufe memory_mb.

## lwe-C
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## ngokwakufe
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## ezdawudu
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## njengolu
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## lefayela
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## okuphezefa
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## ezdawudu
Okuphezefa ngokwakufe wafedawudu ngokwakufe cpu_model, ngokwakufe memory_mb.

## njengolu
Okuphezefa