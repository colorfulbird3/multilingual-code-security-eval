```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#define MAGIC 0x43
#define TYPE  0x4D
#define HEADER_LENGTH 0x50

typedef struct {
    uint8_t magic;
    uint8_t type;
    uint8_t length;
    uint8_t control;
} __attribute__((packed)) Header;

typedef struct {
    uint8_t length;
    uint8_t control;
} __attribute__((packed)) Field;

typedef struct {
    Header header;
    Field fields[13];
} __attribute__((packed)) Packet;

void print_packet(const Packet *pkt) {
    printf("Header: Magic=0x%02X, Type=0x%02X, Length=0x%02X, Control=0x%02X\n",
           pkt->header.magic, pkt->header.type, pkt->header.length, pkt->header.control);
    for (int i = 0; i < 13; i++) {
        printf("Field %d: Length=0x%02X, Control=0x%02X\n", i, pkt->fields[i].length, pkt->fields[i].control);
    }
}

int verify_integrity(const Packet *pkt) {
    if (pkt->header.magic != MAGIC) return 0;
    if (pkt->header.type != TYPE) return 0;
    if (pkt->header.length != HEADER_LENGTH) return 0;
    // Additional integrity checks can be added here
    return 1;
}

int main() {
    Packet pkt = {0};
    pkt.header.magic = MAGIC;
    pkt.header.type = TYPE;
    pkt.header.length = HEADER_LENGTH;
    pkt.header.control = 0x00;

    for (int i = 0; i < 13; i++) {
        pkt.fields[i].length = 0x00;
        pkt.fields[i].control = 0x00;
    }

    if (verify_integrity(&pkt)) {
        printf("Packet integrity verified.\n");
        print_packet(&pkt);
    } else {
        printf("Packet integrity check failed.\n");
    }

    return 0;
}
```