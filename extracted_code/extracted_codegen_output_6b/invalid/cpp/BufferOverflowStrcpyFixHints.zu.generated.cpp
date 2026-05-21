c = *ptr++)!= '\0') {
        hash = ((hash << 5) + hash) + c;
    }

    current_index++;
    return hash % 50;
}

#ifndef API_KEY_MANAGER_H
#define API_KEY_MANAGER_H
#endif

#endif