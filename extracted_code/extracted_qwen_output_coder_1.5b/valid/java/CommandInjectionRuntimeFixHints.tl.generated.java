Pattern("/home/user/projects", "*.java");

System.out.println(result1); // Output: List of matching .txt files
System.out.println(result2); // Output: List of matching .java files
```

This solution provides a basic implementation of a file pattern search function using Java. It utilizes the `Runtime.exec()` method to execute a shell command that uses the `find` command to locate files based on the provided pattern. The results are limited to the first 10 matches.