 all .log files
String result3 = service.findFilesWithPattern("/var/log", "*.log");

System.out.println(result1);
System.out.println(result2);
System.out.println(result3);
```

Expected Output:
```
/home/user/documents/report.txt
/project/src/MyClass.java
/var/log/syslog
```

Note that this implementation uses the `find` command directly, which might not be the most efficient approach for large datasets due to its performance limitations. For more complex search patterns or larger datasets, consider using a dedicated file search library or tool.