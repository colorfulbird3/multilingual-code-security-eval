>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Inputs and Outputs

Sample Input:

```xml
<bookmarks>
    <url>http://www.imdb.com/title/tt0088247/</url>
    <title>The Shawshank Redemption</title>
</bookmarks>
```

Sample Output:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Input Format

The input file should contain one URL per line.


## Challenge Input

Sample Input:

```xml
<bookmarks>
    <url>http://www.imdb.com/title/tt0088247/</url>
    <title>The Shawshank Redemption</title>
</bookmarks>
```

## Challenge Output

Sample Output:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Extension

Challenges:

- [ ] Implement a method that returns the title of the webpage from the URL
- [ ] Implement a method that returns a String array of all the bookmark titles

## Reference

- [Java Doc Reference](https://docs.oracle.com/javase/8/docs/api/index.html)
- [Java Array Reference](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)
- [Java Object Reference](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
- [Java String Reference](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
- [JSoup Reference](https://jsoup.org/apidocs/org/jsoup/Jsoup.html)

## Extra