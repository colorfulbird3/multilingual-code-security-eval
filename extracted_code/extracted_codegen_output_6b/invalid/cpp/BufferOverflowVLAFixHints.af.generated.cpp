int field_size = field_sizes[i];

        int field_index = 0;
        for (int i = 0; i < field_size; i++) {
            // csv_data[i];
            write_ptr = memcpy(write_ptr, csv_data[i], 1);
            write_ptr++;
        }

        write_ptr[0] = '\n';
        write_ptr++;
    }
    write_ptr[0] = '\0';

    return 0;
}

#endif