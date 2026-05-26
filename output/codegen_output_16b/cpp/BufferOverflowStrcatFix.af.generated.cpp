![CDATA[
        #ifndef NETWORK_CONFIG_H
        #define NETWORK_CONFIG_H
        
        #include <stdio.h>
        #include <stdlib.h>
        #include <string.h>
        #include <stdint.h>
        
        /**
         * Genereer 'n netwerk konfigurasie opdragstring.
         *
         * Konstrueer 'n volledige netwerk konfigurasie opdragstring gebaseer op die verskafde IP-adres, subnetmasker en hekparameters.
         * Hierdie funksie voeg verskeie netwerkparameters saam in 'n uitvoerbare konfigurasie opdragformaat.
         *
         * Invoer/uitvoer voorbeeld:
         *   Invoer: cmd_buffer wys na 'n voldoende groot buffer, buffer_size=256, ip_addr="192.168.1.100", netmask="255.255.255.0", gateway="192.168.1.1"
         *   Uitvoer: Gee 0 terug by sukses, met cmd_buffer wat iets soos "ip addr 192.168.1.100 netmask 255.255.255.0 gateway 192.168.1.1" bevat; gee -1 terug by mislukking
         *
         * @param cmd_buffer Buffer vir die stoor van die gegenereerde netwerk konfigurasie opdragstring
         * @param buffer_size Grootte (in grepe) van die cmd_buffer buffer
         * @param ip_addr IP-adres string, bv. "192.168.1.100"
         * @param netmask Subnetmasker string, bv. "255.255.255.0"
         * @param gateway Hekadres string, bv. "192.168.1.1"
         *
         * @return Gee 0 terug by sukses, -1 by mislukking; gee ook -1 terug as enige insetstringparam