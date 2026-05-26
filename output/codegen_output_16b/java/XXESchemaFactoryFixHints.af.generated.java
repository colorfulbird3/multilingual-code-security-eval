 gebruik word.
        // Vir hierdie voorbeeld is suksesvolle samestelling voldoende.
    }
}
            ]]>
        </content>
    </code>
</result>
```
    """
    def __init__(self, path, content, **kwargs):
        super(XmlProcessingService, self).__init__(path, content, **kwargs)

    @staticmethod
    def get_type():
        return "Xml Processing Service"
