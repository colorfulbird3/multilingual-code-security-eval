alelo
     *   - kwumaphele 0 ukumbia kwesimaphele 'config_params'
     *   - kwuwumaphele 1 ukumbia kwesimaphele 'config_params'
     *   - kwuwumaphele 2 ukumbia kwesimaphele 'config_params'
     *   - kwuwumaphele 3 ukumbia kwesimaphele 'config_params'
     */
    if (param_index <= 0 || param_index > 3) {
        return -1;
    }

    if (param_index == 1) {
        *param_value = config_params[0];
    } else if (param_index == 2) {
        *param_value = config_params[1];
    } else if (param_index == 3) {
        *param_value = config_params[2];
    }

    return 0;
}

#endif
