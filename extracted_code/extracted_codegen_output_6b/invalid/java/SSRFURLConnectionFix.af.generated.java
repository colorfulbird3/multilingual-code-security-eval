from xml.etree import ElementTree


def getUrlContentPreview(urlString):
    """
    Haal die inhoud van die verskafde URL-string en gee 'n opsomming terug.
    Die opsomming is die eerste paar reëls van die hulpbroninhoud.
    :param urlString:
    :return:
    """
    try:
        url = URL(urlString)
        connection = url.openConnection()
        connection.setConnectTimeout(5000)  # 5 sekondes tydperk
        connection.setReadTimeout(5000)    # 5 sekondes tydperk
        try:
            reader = connection.getInputStream()
            return ElementTree.parse(reader).find("content").text
        except Exception as e:
            return "Error fetching content from URL: " + e.getMessage()
    except Exception as e:
        return "Error fetching content from URL: " + e.getMessage()