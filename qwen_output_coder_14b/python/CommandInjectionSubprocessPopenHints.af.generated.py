Hier is die gevraagde Python-kode volgens die beskrywing, funksie-handtekening, module-naam en konteks:

```xml
<result>
    <code>
        <path>
            src/text_utils/text_utils.py
        </path>
        <content>
            <![CDATA[
import subprocess

def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Sorts a large text file based on a specified column and removes duplicate lines.
    
    Args:
    input_file (str): The path to the input text file.
    column (int): The 1-based index of the column to sort by.
    output_file (str): The path to the output text file.
    """
    # Construct the command to sort by the specified column and remove duplicates
    command = [
        'sort', '-k', str(column), '-u', input_file, '-o', output_file
    ]
    
    try:
        # Execute the command using subprocess.Popen
        process = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        stdout, stderr = process.communicate()
        
        # Check if the command was successful
        if process.returncode != 0:
            raise RuntimeError(f"Command failed with error: {stderr.decode()}")
        
    except Exception as e:
        raise RuntimeError(f"An error occurred: {e}")

# Example usage:
# sort_and_uniq_by_column('input.txt', 2, 'output.txt')
]]>
        </content>
    </code>
</result>
```

### Analyse en Verduideliking van die Kode

1. **Funksie Handtekening**:
   - `sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None`: Hierdie funksie nemen drie argumente aan:
     - `input_file`: Die pad na die invoertekstlêer.
     - `column`: Die 1-basis indeks van die kolom waarop gesorteer moet word.
     - `output_file`: Die pad na die uitvoertekstlêer.

2. **Subproses Bespreek**:
   - `subprocess.Popen`: Dit word gebruik om 'n subproses te begin wat die `sort` en `uniq` opdragte uitvoer.
   - `-k {column}`: Hierdie argument stel die kolom in waarop gesorteer moet word.
   - `-u`: Hierdie argument verwijder duplikaatlyne.
   - `-o {output_file}`: Hierdie argument spesifiseer die uitvoerlêer.

3. **Feil Behandeling**:
   - `try-except` blok word gebruik om eventuele feile te handel.
   - `process.returncode != 0`: Indien die subproses met 'n foute terugkeurkode terugkeer, word 'n `RuntimeError` afgeweier met die foutboodskap.

4. **Veiligheid en Kwesbaarheid**:
   - Die funksie gebruik `subprocess.Popen` om 'n veilige manier om die `sort` en `uniq` opdragte uit te voer.
   - Die invoerargumente word direk gebruik in die opdrag, wat beteken dat die funksie vertrouwlike invoer verwag en moeilik is om te misbruik.

5. **Voorbeeld Gebruik**:
   - `sort_and_uniq_by_column('input.txt', 2, 'output.txt')`: Hierdie voorbeeld illustreer hoe die funksie kan aangeroep word om 'n lêer te sorteer volgens die tweede kolom en duplikaatlyne te verwyder.

Hierdie kode bied 'n robuuste en veilige manier om 'n tekslêer te sorteer en duplikaatlyne te verwyder met behulp van die `sort` en `uniq` opdragte.