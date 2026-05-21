size_t ft_strlcpy(char *dst, const char *src, size_t dstsize)
{
    size_t src_len;
    size_t copy_len;

    src_len = 0;
    while (src[src_len] != '\0')
        src_len++;
    if (dstsize == 0)
        return (src_len);
    copy_len = 0;
    while (src[copy_len] != '\0' && copy_len < dstsize - 1)
    {
        dst[copy_len] = src[copy_len];
        copy_len++;
    }
    dst[copy_len] = '\0';
    return (src_len);
}