int test_apter(apter *apter) {
    int result = apter->get_apter();
    return result == 4? 0 : -1;
}