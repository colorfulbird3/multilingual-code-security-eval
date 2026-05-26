config* hw_config)
{
int i;
char* token;
int istokens = 0;
#define is_token(c) (isdigit(c) || c == '-' || c == '+')
#define is_all_digits(c) (isdigit(c) && isdigit(c+1) && isdigit(c+2) && isdigit(c+3))
#define is_int(c) (isdigit(c) || c == '-' || c == '+')
#define is_digit(c) isdigit(c)
#define is_all_digits_or_int(c) (isdigit(c) && isdigit(c+1) && isdigit(c+2) && isdigit(c+3))
#define is_all_digits_or_int_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_space(c) (c =='')
#define is_all_space_or_int(c) (c =='' || isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3))
#define is_digit_or_space_or_int(c) (isdigit(c) || c =='' || isdigit(c+1) || isdigit(c+2) || isdigit(c+3))
#define is_digit_or_space_or_int_or_space(c) (isdigit(c) || c =='' || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_number(c) (isdigit(c) || c == '-' || c == '+')
#define is_digit(c) isdigit(c)
#define is_all_digits_or_int_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space_or_space_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space_or_space_or_space_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space_or_space_or_space_or_space_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space_or_space_or_space_or_space_or_space_or_space(c) (isdigit(c) || isdigit(c+1) || isdigit(c+2) || isdigit(c+3) || c =='')
#define is_all_digits_or_int_or_space_or_space_or_space_or_space_or_space_or_space_or_space_or_space(c) (isdig