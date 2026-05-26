String command = "find";
String params = "";
String result = "";
// find -name fileName
result = Runtime.getRuntime().exec(command + " -name " + params).toString();
// find -type f
result = Runtime.getRuntime().exec(command + " -type f " + params).toString();