`xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## example
// ```c
// int get_device_config_param(int config_params[50], int param_index, int *param_value)
// {
//     int i;
//     for(i=0;i<50;i++)
//     {
//         if(config_params[i]==param_index)
//         {
//             *param_value = i;
//             return 0;
//         }
//     }
//     return -1;
// }
// ```
