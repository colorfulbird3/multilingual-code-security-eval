 || gateway == NULL) {
// return -1;
// }
// // Ukuhlola ukuthi awekho amapharamitha angenalutho
// if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
// return -1;
// }
// // Ukuhlola ubukhulu bebhafa ukuze kugwenywe ukugcwala
// size_t total_length = strlen("ip addr ") + strlen(ip_addr) +
// strlen(" netmask ") + strlen(netmask) +
// strlen(" gateway ") + strlen(gateway) + 1; // +1 for null terminator
// if (total_length > buffer_size) {
// return -1;
// }
// // Ukwakha umyalo wokumisa inethiwekhi
// cmd_buffer[0] = '\0'; // Qala ngentambo engenalutho
// strncat(cmd_buffer, "ip addr ", buffer_size - strlen(cmd_buffer) - 1);
// strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer) - 1);
// strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer) - 1);
// strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer) - 1);
// strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer) - 1);
// strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer) - 1);
// return 0;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// @param[in] filename filename of the xml file
// @param[in] root_element element of the xml file to parse
// @param[in] ignore_element element of the xml file to ignore
// @returns parse result
// */
parse_result parse_file(std::string filename, boost::optional<std::string> root_element, boost::optional<std::string> ignore_element) {
    std::string content;
    std::string error_message;
    std::string error_id;
    int error_code;
    int error_status;

    if (!file_exists(filename)) {
        error_code = UNKNOWN_ERROR;
        error_id = "COULD NOT FIND FILE: " + filename;
        error_status = FILE_NOT_FOUND;
        error_message = error_id + " :: " + error_message + FILE_NOT_FOUND_TXT;
        return parse_result(error_code, error_id, error_status, error_message);
    }

    if (!read_file(filename, content)) {
//        std::cout << "Could not read file: " << filename << std::endl;
        error_code = UNKNOWN_ERROR;
        error_id = "COULD NOT READ FILE: " + filename;
        error_status = FILE_READ_FAILED;
        error_message = error_id + " :: " + error_message + FILE_READ_FAILED_TXT;
        return parse_result(error_code, error_id, error_status, error_message);
    }

    bool ignore = (ignore_element!= boost::optional<std::string>{});

    parse_result result = parse_xml(content, filename, root_element, ignore);

    return result;
}

} // namespace network_config_parse

} // namespace network_config
