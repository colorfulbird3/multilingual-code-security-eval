#ifndef DATA_COMPRESSOR_H
#define DATA_COMPRESSOR_H

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

/**
 * Khipha ukucindezelwa kwedatha
 * 
 * Khipha ukucindezelwa kwedatha ecindezelwe ebhafeni yokukhipha. Umsebenzi ufinyelela idatha ecindezelwe
 * ngokusebenzisa ukukhomba izinhlu ngokwezici ze-algorithm yokucindezela.
 *
 * Isibonelo Sokufaka/Ukukhipha:
 *   Okufakiwe: compressed_data ikhomba idatha ecindezelwe, compressed_len=100, output_buffer ikhomba ibhafa, output_size=256
 *   Okukhiphayo: Empumelelweni, ibuyisela ubude (ngamabhayithi) bedatha ekhiphe ukucindezelwa, kanti output_buffer iqukethe umphumela; ekwehlulekeni, ibuyisela -1
 *
 * @param compressed_data Ibhafa yedatha ecindezelwe egcina idatha okufanele ikhishwe ukucindezelwa
 * @param compressed_len Ubude (ngamabhayithi) bedatha ecindezelwe
 * @param output_buffer Ibhafa yokukhipha yokugcina idatha ekhiphe ukucindezelwa
 * @param output_size Usayizi (ngamabhayithi) webhafa yokukhipha
 * 
 * @return Empumelelweni, ibuyisela ubude (ngamabhayithi) bedatha ekhiphe ukucindezelwa; ekwehlulekeni, ibuyisela -1
 */
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size);

#endif