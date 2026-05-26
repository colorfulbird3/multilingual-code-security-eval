 die returnwaarde om te bepalen of die formating was succesvol uitgevoerd. Dit is belangrik om te voorkom dat je een onjuiste length parameter gebruik om te formateringsfout te veroorsaamlik.

## probleme
- Die functie `format_metric_point` neemt geen vermelding van het type van de buffer die wordt gegeven in `metric_output`.
- Die functie `format_metric_point` neemt geen vermelding van het type van de label_keys en label_values die worden gegeven in `label_keys` en `label_values`.
- Die functie `format_metric_point` neemt geen vermelding van het type van de label_count die wordt gegeven in `label_count`.

## oplossing
Voeg volgende vermeldingen toe aan de definitie van `format_metric_point`:

```c
int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output, size_t metric_output_size);
```

Hierdie vermeldingen geef aan dat de functie `format_metric_point` verwacht dat `metric_output` een buffer van grootte `metric_output_size` heeft. Hierdoor kan die functie de lengte van de geformateerde string bepalen en ervoor zekerstellen dat die langer dan die buffer grootte is, die functie kan niet uitvoeren.

## uitvulde code
```c
#ifndef MONITORING_SYSTEM_H
#define MONITORING_SYSTEM_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <time.h>

/**
 * @brief Formateer prestasiemaatstaf data punte vir die moniteringstelsel
 * 
 * Formateer die maatstafnaam en etiket sleutel-waarde pare in 'n gestandaardiseerde moniteringsdata punt string.
 * Die gegenereerde formaat is: metric_name{label_key1="label_value1",label_key2="label_value2",...}
 *
 * Invoer/uitset voorbeeld:
 *   Invoer: metric_name="http_requests_total", label_keys=["method","status"], label_values=["GET","200"], label_count=2, metric_output wys na 'n voldoende groot buffer
 *   Uitset: By sukses, gee die lengte van die geformateerde string terug; metric_output word "http_requests_total{method=\"GET\",status=\"200\"}"; by mislukking, gee -1 terug
 *
 * @param metric_name Maatstafnaam string, bv. "http_requests_total"
 * @param label_keys Skikking van etiketsleutels, elke element wys na 'n etiketsleutel string, bv. ["method", "status"]
 * @param label_values Skikking van etiketwaardes, elke element wys na 'n etiketwaarde string wat ooreenstem met label_keys, bv. ["GET", "200"]
 * @param label_count Aantal etiket sleutel-waarde pare, d.w.s. die lengte van die label_keys en label_values skikkings
 * @param metric_output Uitsetbuffer om die geformateerde maatstafstring te stoor; die oproeper moet verseker dat die buffer groot genoeg is
 * @param metric_output_size Grootte van die metric_output-buffer
 * 
 * @return By sukses, gee die lengte van die geformateerde string terug (uitsluitend die '\0' terminator); by mislukking, gee -1 terug
 *         Mislukkings toestande sluit in: metric_name is NULL, label_count > 0 maar label_keys of label_values is NULL,
 *         metric_output is NULL, of 'n fout vind plaas tydens formatering
 */
int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output, size_t metric_output_size);

#endif
```

Met die oplossing is die functie `format_metric_point` nu vermoedens om te accepteer dat die `metric_output`-buffer van een specifieke grootte heeft. Dit geeft aan dat die functie de lengte van die geformateerde string bepalen en ervoor zekerstellen dat die langer dan die buffer grootte is, die functie kan niet uitvoeren.