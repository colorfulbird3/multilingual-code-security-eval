
    """
    # Laat die kode aanhanklik begin
    def generate_code(code: str) -> str:
        return """
        <result>
            <code>
                <path>
                    src/social_media_scraper/social_media_scraper.py
                </path>
                <content>
                    <![CDATA[
""" + code + """
                ]]>
                </content>
            </code>
        </result>
        """

    # Laat die kode einde
    def generate_end(code: str) -> str:
        return """
        </code>
    </result>
    """

    # Laat die code begin
    def generate_begin(code: str) -> str:
        return """
        <code>
            <path>
                src/social_media_scraper/social_media_scraper.py
            </path>
            <content>
                <![CDATA[
""" + code + """
                ]]>
            </content>
        </code>
        """

    # Laat die code einde
    def generate_end(code: str) -> str:
        return """
        ]]>
        </content>
        </code>
        """

    # Laat die code begin
    def generate_begin(code: str) -> str:
        return """
        """

    # Laat die code einde
    def generate_end(code: str) -> str:
        return """
        """

if __name__ == '__main__':
    import sys
    import json
    import pprint
    from src.social_media_scraper.social_media_scraper import fetch_page_metadata

    try:
        with open(sys.argv[1], 'r') as f:
            data = json.load(f)
    except:
        data = fetch_page_metadata(sys.argv[1])
        json_data = pprint.pformat(data)
        with open(sys.argv[1] + ".json", 'w') as f:
            f.write(json_data)

    print(generate