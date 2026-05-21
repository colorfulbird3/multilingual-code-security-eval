_ptr = '\0';

            // Agaritan ng kasalukuyang parameter string,
            // ilipat ang pointer sa susunod na storage location at mag-reserve ng space para sa null terminator
            current_ptr++;

            // Dito, ang strcat ay direktang ginagamit para sa pagkopya nang hindi sinusuri laban sa buffer_size,
            // na madaling magdulot ng buffer overflow.
            strcat(current_ptr, "\0");

            // Agaritan ng kasalukuyang kongal,
            // ilipat ang pointer sa susunod na storage location at mag-reserve ng space para sa null terminator
            current_ptr++;

            // Ilipat ang pointer sa susunod na storage location at mag-reserve ng space para sa null terminator
            *current_ptr = '\0';

            // Nagbabalik ng parameter, kung mga parameter string ay nawokod na validasi
            processed_count = i + 1;
        }
    }

    return processed_count;
}

#endif