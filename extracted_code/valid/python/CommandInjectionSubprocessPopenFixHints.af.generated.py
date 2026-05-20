import subprocess
import os


def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
    """
    Verwerk 'n tekslêer deur dit te sorteer gebaseer op 'n gespesifiseerde kolom en duplikaatlyne te verwyder.

    Args:
        input_file: Pad na die brontekslêer wat verwerk moet word
        column: Kolomnommer (1-gebaseer) om as die sorteer-sleutel te gebruik
        output_file: Pad waar die verwerkte resultaat gestoor sal word
    """
    if not os.path.exists(input_file):
        raise FileNotFoundError(f"Invoerlêer nie gevind nie: {input_file}")

    # Valideer die kolomnommer
    if column <= 0:
        raise ValueError("K