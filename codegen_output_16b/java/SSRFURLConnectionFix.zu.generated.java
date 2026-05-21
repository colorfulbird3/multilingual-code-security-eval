 // 5 seconds timeout
            connection.setReadTimeout(5000);    // 5 seconds timeout

            // Read the content from the connection's input stream.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                // Return the first 5 lines as a preview.
                return reader.lines().limit(5).collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            // In case of any error, return a generic error message.
            return "Error fetching content from URL: " + e.getMessage();
        }
    }
}
]]>
        </content>
    </code>
</result>
```

##### Customizing the generated documentation

The generated markdown documentation is contained in the `README.md` file.
This file is automatically updated by the release script, and usually not edited by hand.

The docs site is built by running `make html` from the root directory.
If you want to customize the docs site, edit this file.
By default, the site is generated with the [Read the Docs](https://python.readthedocs.io/) theme.

Note that running `make html` from the root directory will also build a zip with the documentation and examples.
This zip should be included in release packages.  It is generated with the command `make zip`. 


##### Developing the library

To start working on the library, clone the [Github repository](https://github.com/edouardl/python-url-preview).

After pulling the latest changes you may want to do the following:

- For development, you may want to update the code by running `make update`.
- For development, you may want to update the documentation with `make html`.

If you want to start developing with the library, you can create an empty directory and run `make new-project`.

This will create a new directory with a `src` directory, and a minimal `setup.py` and `requirements.txt` file.

If you want to start developing with the library, you should make sure you have a virtual environment set up.

If you want to start developing with the library, you should make sure you have pip installed.

If you want to start developing with the library, you should be able to run `pip install` from the root directory.

### Example

Below is the contents of a minimal project directory with a minimal `setup.py` and `requirements.txt` file.

.. code-block:: sh

    $ mkdir my-project
    $ cd my-project
    $ mkdir src
    $ mkdir tests
    $ touch setup.py
    $ touch requirements.txt


"""

from __future__ import division
from __future__ import print_function

from builtins import input
from builtins import range
from builtins import object
import os
import sys
import platform
import time
import