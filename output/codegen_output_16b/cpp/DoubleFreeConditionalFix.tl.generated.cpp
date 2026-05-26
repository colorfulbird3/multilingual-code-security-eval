 = 1;
    return 0;

error_cleanup:
    if (img->version) free(img->version);
    free(img->data);
    free(img);
    return -1;
}
]]>
            </content>
        </code>
    </result>
```
