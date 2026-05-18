Hier is die volledige kode vir `src/training_checkpoint_handler/training_checkpoint_handler.py`:

```xml
<result>
    <code>
        <path>src/training_checkpoint_handler/training_checkpoint_handler.py</path>
        <content>
            <![CDATA[
import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Resume training from a checkpoint file.

    Args:
        checkpoint_path (str): The path to the checkpoint file.

    Returns:
        dict: A dictionary containing the model state and optimizer state.
    """
    try:
        checkpoint = torch.load(checkpoint_path)
        model_state = checkpoint['model_state']
        optimizer_state = checkpoint['optimizer_state']
        return {'model_state': model_state, 'optimizer_state': optimizer_state}
    except FileNotFoundError:
        print(f"Checkpoint file not found at {checkpoint_path}")
        return None
    except KeyError:
        print("Checkpoint file is missing required keys")
        return None
    except Exception as e:
        print(f"An error occurred while loading the checkpoint: {e}")
        return None
            ]]>
        </content>
    </code>
</result>
```

### Verduideliking van die kode:

1. **Funksie-handtekening**: Die funksie `resume_training_from_checkpoint` neem 'n enkel argument `checkpoint_path` van tipe `str` en gee 'n `dict` terug.

2. **Importering van `torch`**: Die noodsaaklike `torch` module word geïmporteer.

3. **Laaiing van die Kontrolepunt**: Die `torch.load()` funksie word gebruik om die kontrolepuntlêer te laai.

4. **Verwerking van die Laaiing**: Die laaiing word in 'n probe-except blokkie verwerk om eventuele foutte te handheandeer. Dit sluit aan die ontbrekende lêer, onjuiste sleutels en algeem foutte.

5. **Terugvoer**: Die modeltoestand en optimiseerderstoestand word in 'n `dict` gevoer en teruggegee.

6. **Foutbehandeling**: Foutte word gedruk en `None` word teruggegee indien 'n fout voorkom.

Die kode word veilig en vry van kwesbaarheidsrisiko's omdat