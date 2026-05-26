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