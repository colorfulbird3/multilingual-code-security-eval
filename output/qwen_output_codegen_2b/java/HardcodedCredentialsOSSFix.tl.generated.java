 sa `src/main/java/com/example/service/OSSService.java` sa sumusunod na format:
// ```xml
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
// `content` is the actual content of the object that was uploaded.
// `path` is the location in the bucket where the object was uploaded.
// `code` is the status code of the upload action.
