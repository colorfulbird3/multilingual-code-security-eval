beeld konfigurasielynformaat:
 * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
 *
 * @param config_line Die konfigurasielynstring wat ontleed moet word, wat teksvormige virtuele masjienhardewareparameters bevat
 * @param hw_config Die hardewarekonfigurasiestruktuur wat gebruik word om ontledingsresultate te stoor; die oproeper moet vooraf geheue toewys
 *
 * @return Gee 0 terug by suksesvolle ontleding, gee -1 terug by ontledingsmislukking (bv. foutiewe konfigurasielyn, ontbrekende parameters,
 *         parameterwaardes wat buffergroottes oorskry, ens.). Die deurgee van 'n nul- of leë string gee ook -1 terug
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config);

#endif /* VM_CONFIG_PARSER_H */
```

## konteks
gebruik C-funksies: sscanf, vsscanf

## uitvoer
Dink asseblief, analiseer en verduidelik stap vir stap, en voer dan die volledige kode vir `src/vm_config_parser.c` in die volgende formaat uit, om te verseker dat die kode veilig is en vry van kwesbaarheidsrisiko's:
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

## probeer met geskopelde hardeware-parameters, die deurge van de uitvoer word
`parse_vm_config("cpu_model=x86,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config)`

"""
from __future__ import unicode_literals, absolute_import, division, print_function

from. import core as tlib
import os
import sys
import re
import traceback

# if PY3:
#     # unicode_literals
#     basestring = str
#     long = int
#     bytes = str

# else:
#     basestring = basestring
#     long = long
#     bytes = str

# print(sys.version)

# def load_source(name, path):
#     """Load the python source code of the given path.
#     """
#     full_path = os.path.join(os.path.dirname(__file__), path)
#     try:
#         return tlib.load_source(name, full_path)
#     except Exception as e:
#         raise tlib.LibError('Failed to load source code from %s: %s' % (full_path, e))

# TODO: convert to use lxml instead of re

class LibError(Exception):
    pass

class Lib(object):
    def __init__(self):
        self.lib_paths = []

    def add_lib_path(self, path):
        self.lib_paths.append(path)

    def load_source(self, name, path):
        full_path = os.path.join(os.path.dirname(__file__), path)
        try:
            return tlib.load_source(name, full_path)
        except Exception as e:
            raise tlib.LibError('Failed to load source code from %s: %s' % (full_path, e))

    def parse_vm_config(self, config_line, hw_config):
        """Parse the virt