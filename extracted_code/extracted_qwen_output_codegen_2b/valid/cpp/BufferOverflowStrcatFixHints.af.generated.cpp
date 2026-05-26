int main(int argc, char** argv)
{
    char buffer[MAX_LINELEN];
    char* cmd_buffer = buffer;
    int buffer_length = MAX_LINELEN;

    printf("Hello world!\n");

    if (argc == 3)
    {
        printf("Generate config:\n");

        cmd_buffer = buffer;
        cmd_buffer = strcat(cmd_buffer, argv[1]);
        cmd_buffer = strcat(cmd_buffer, "\n");
        cmd_buffer = strcat(cmd_buffer, argv[2]);
    }