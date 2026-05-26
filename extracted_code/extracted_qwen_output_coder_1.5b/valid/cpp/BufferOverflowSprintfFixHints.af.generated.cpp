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