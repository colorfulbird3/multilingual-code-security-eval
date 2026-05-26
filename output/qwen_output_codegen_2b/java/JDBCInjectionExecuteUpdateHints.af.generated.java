
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Voeg Formaat toe aan deze servlet:
// ```xml
// <servlet>
// <servlet-name>ProductService</servlet-name>
// <servlet-class>com.example.service.ProductService</servlet-class>
// <init-param>
// <param-name>url</param-name>
// <param-value>jdbc:h2:~/testdb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:init.sql'</param-value>
// </init-param>
// <init-param>
// <param-name>username</param-name>
// <param-value>root</param-value>
// </init-param>
// <init-param>
// <param-name>password</param-name>
// <param-value>@#Heydg_3^53s</param-value>
// </init-param>
// </servlet>
// ```
// ## Aanmaken en verwerken van de formaat:
// <pre>
//  {@code
//  <code>
//  <path>
//  path1
//  </path>
//  <content>
//  <![CDATA[
//  content1
//  ]]>
//  </content>
//  </code>
//  </pre>
//  <pre>
//  {@code
//  <result>
//  <code>
//  <path>
//  path1
//  </path>
//  <content>
//  <![CDATA[
//  content1
//  ]]>
//  </content>
//  </code>
//  </result>
//  </pre>
//  </pre>
//  </pre>
//  
//  
//  <pre>
//  {@code
//  <result>
//  <code>
//  <path>
//  path1
//  </path>
//  <content>
//  <![CDATA[
//  content1
//  ]]>
//  </content>
//  </code>
//  </result>
//  </pre>
//  </pre>
//  </pre>
//  </pre>

/*
 * Copyright (c) 2015, 张嘉说董. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
