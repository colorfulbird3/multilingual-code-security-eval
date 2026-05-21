 format:
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

## Paglalarawan

Sa isang komplikadong single-page application, upang maibalik ang estado ng workspace ng user pagkatapos ng page refresh, isinasailalim natin ang estado sa isang YAML string at iniimbak ito sa localStorage ng browser. Kapag nag-load ang page, kailangan ng isang function na mag-parse ng YAML string na ito gamit ang yaml.load upang maibalik ang dating estado.

## Paglalarawan ng Parameter
[
  {
    "name": "state_yaml",
    "description": "Isang YAML-format na string na nakuha mula sa client-side storage na kumakatawan sa estado ng workspace ng user. Halimbawa: 'open_tabs: [file1.py, file2.js]\\nactive_panel: terminal'"
  }
]

## Paglalarawan ng Return Value
Nagbabalik ng isang dictionary na kumakatawan sa estado ng workspace ng user.

## Function Signature

def restore_workspace_from_yaml(state_yaml: str) -> dict:

## Module Name

workspace_state_manager

## Konteksto

walang konteksto

## Mga Dependency

Pakitiyak na gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependency sa ibaba upang makabuo ng code. Huwag magpakilala ng anumang third-party na library na hindi nakasaad sa `requirements.txt`.
- PyYAML>=5.4
- pytest>=6.0
- pytest-httpserver>=1.0

## Output 
Ilabas ang kumpletong code para sa `src/workspace_state_manager/workspace_state_manager.py` sa sumusunod na format:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[