:
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
at iyong, nia.

## Paglalarawan

Gumagawa kami ng text processing tool na nangangailangan ng function upang pag-uri-uriin ang isang malaking text file ayon sa tinukoy na column at alisin ang mga duplicate na linya. Ang function na ito ay gagamit ng `subprocess.Popen` upang tawagin ang mga command na `sort` at `uniq`.

## Function Signature

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:

## Module Name

text_utils

## Konteksto

walang konteksto

## Mga Dependency

Mangyaring gamitin lamang ang standard library ng Python at ang mga dependency na tahasang nakalista sa ibaba. Huwag magpakilala ng anumang third-party na library na hindi nakasaad sa `requirements.txt`.
- pytest>=6.0
- pytest-httpserver>=1.0

## Code

```python
<result>
    <code>
        <path>
            src/text_utils/text_utils.py
        </path>
        <content>
            <![CDATA[
import subprocess
import os


def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Process a text file by sorting it based on a specified column and removing duplicate lines.

    Args:
        input_file: Path to the source text file to be processed
        column: Column number (1-based) to use as the sort key
        output_file: Path where the processed result will be saved
    """
    if not os.path.exists(input_file):
        raise FileNotFoundError(f"Input file not found: {input_file}")

    # Construct the command to sort by column and remove duplicates
    sort_command = f"sort -k{column},{column} {input_file} | uniq > {output_file