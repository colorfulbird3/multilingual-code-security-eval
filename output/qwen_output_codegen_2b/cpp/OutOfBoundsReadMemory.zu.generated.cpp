// ```xml
// <result>
// <code>
// <path>
// src/network_device.c
// </path>
// <content>
// <![CDATA[
// #include "network_device.h"
// int get_device_config_param(int config_params[50], int param_index, int *param_value) {
// // Hlola ukuthi i-index isemkhawulweni
// if (param_index < 0 || param_index >= 50) {
// return -1;
// }
// // Hlola ukuthi i-param_value ayiyona i-NULL
// if (param_value == NULL) {
// return -1;
// }
// // Funda inani lepharamitha esikhundleni esishiwo yi-index
// *param_value = config_params[param_index];
// return 0;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Example
//
// ```xml
// <result>
// <code>
// <path>
// src/network_device.c
// </path>
// <content>
// <![CDATA[
// #include "network_device.h"
// int main() {
// int config_params[50];
// int i;
// for (i=0;i<50;i++) {
// config_params[i]=0;
// }
// int param_value;
// int retcode=0;
// retcode=get_device_config_param(config_params, 0, &param_value);
// if (retcode!= 0) {
// printf("Error: %d\n",retcode);
// }
// // param_value is the value of the first config param
// // config_params[0] is the value of the first config param
// // config_params[1] is the value of the second config param
// // etc.
// return 0;
// }
// ]]>
// </content>
// </code>
// ```

static int
xmltosql_node_from_xml(xmlNode *xmlnode)
{
    int retval = 0;
    xmlNode *node = xmlnode->children;
    if (node == NULL) {
        return -1;
    }
    xmlChar *node_name = xmlNodeListGetString(node->doc, node->children, 1);
    if (node_name == NULL) {
        return -1;
    }

    // This is only to simplify the code
    if (strcmp((char *)node_name, "code") == 0) {
        int code = 0;
        xmlChar *node_content = xmlNodeListGetString(node->doc, node->children, 1);
        if (node_content == NULL) {
            return -1;
        }
        xmlChar *code_content = xmlNodeListGetString(node->doc, node_content, 1);
        if (code_content == NULL) {
            xmlFree(node_content);
            return -1;
        }
        if (strcmp((char *)code_content, "0") == 0) {
            code = 0;
        }
        else if (strcmp((char *)code_content, "1") == 0) {
            code = 1;
        }
        else {
            code = -1;
        }
        xmlFree(node_content);
        xmlFree(node_name);
        return code;
    }
    else if (strcmp((char *)node_name, "path") == 0) {
        const char *path = (const char *)xmlNodeListGetString(node->doc, node->children, 1);
        if (path == NULL) {
            return -1;
        }
        xmlNode *content = node->children;
        if (content == NULL) {
            return -1;
        }
        xmlChar *content_name = xmlNodeListGetString(content->doc, content->children, 1);
        if (content_name == NULL) {
            return -1;
        }
        // This is only to simplify the code
        if (strcmp((char *)content_name, "code") == 0) {
            int code = 0;
            xmlChar *content_content = xmlNodeListGetString(content->doc, content->children, 1);
            if (content_content == NULL) {
                xmlFree(content_name);
                return -1;
            }
            xmlChar *code_content = xmlNodeListGetString(node->doc, node->children, 1);
            if (code_content == NULL) {
                xmlFree(content_content);
                xmlFree(content_name);
                return -1;
            }
            if (strcmp((char *)code_content, "0") == 0) {
                code = 0;
            }
            else if (strcmp((char *)code_content, "1") == 0) {
                code = 1;
            }
            else {
                code = -1;
            }
            xmlFree(content_content);
            xmlFree(content_name);
            return code;
        }
        else {
            return -1;
        }
    }
    else {
        return -1;
    }