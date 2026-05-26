```python
import urllib.request
from urllib.error import URLError

def fetch_page_metadata(page_url: str) -> dict:
    try:
        # Open the URL and read the HTML content
        with urllib.request.urlopen(page_url) as response:
            html_content = response.read().decode('utf-8')
        
        # Placeholder for parsing metadata
        # This is where you would typically use a library like BeautifulSoup
        # to extract metadata such as title, description, etc.
        metadata = {
            'title': 'Placeholder Title',
            'description': 'Placeholder Description'
        }
        
        return metadata
    except URLError as e:
        return {'error': f'Failed to retrieve the page: {e.reason}'}

# Example usage
if __name__ == "__main__":
    url = 'https://example.com/article'
    metadata = fetch_page_metadata(url)
    print(metadata)
```

### Explanation:
1. **Importing Required Modules**: The `urllib.request` module is used to open the URL and read its content. The `URLError` exception is imported to handle any errors that might occur during the request.
2. **Function Definition**: The `fetch_page_metadata` function takes a `page_url` as an argument and returns a dictionary containing the metadata of the page.
3. **Fetching the Page**: The `urlopen` method is used to open the URL, and the content is read and decoded from bytes to a string.
4. **Parsing Metadata**: Currently, the function returns placeholder metadata. In a real-world scenario, you would use a library like BeautifulSoup to parse the HTML and extract the desired metadata (e.g., title, description).
5. **Error Handling**: If there is an error while opening the URL, the function catches the `URLError` and returns an error message.
6. **Example Usage**: The script includes an example usage section that demonstrates how to call the function and print the metadata.

This code provides a basic structure for fetching and parsing metadata from a web page. You can expand it by adding more sophisticated HTML parsing logic using libraries like BeautifulSoup or lxml.