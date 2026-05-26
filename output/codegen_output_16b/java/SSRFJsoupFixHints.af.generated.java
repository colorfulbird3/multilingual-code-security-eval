


## Besturingselementen

- `result`: code. 
- `code`: path.
- `path`: name of directory in `src/main/java/com/example/bookmarks/service` to put code in.

## Afbeelding

Lê die afbeelding in die `src/main/resources/bookmark-service.jpg`. 

## Uitvoer

Uitvoer:

```java
   public static void main(String[] args) {
        BookmarkService service = new BookmarkService();
        System.out.println(service.fetchTitleFromUrl("http://www.google.com"));
    }
```

## Uitvoer result:

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

## Besturingsselementen

- `code`: code.
- `path`: path.

## Afbeelding

Lê die afbeelding in die `src/main/resources/bookmark-service.jpg`.

## Uitvoer afbeelding

Uitvoer afbeelding:

<img src="bookmark-service.jpg" alt="bookmark-service">

## Uitvoer result:

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
"""