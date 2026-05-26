

"""

# Imports
import xmlrunner
import unittest
from pathlib import Path
from ognl import compile
from ognl import OgnlException

## Tests

class OgnlTest(unittest.TestCase):
    def setUp(self):
        self.expression = "ognl:ognl:3.3.4"
        self.dataRoot = "dataRoot"

    def testGetValue(self):
        result = compile(self.expression, self.dataRoot)
        self.assertEqual("user.name", result)

    def testBadOgnlExpression(self):
        expression = "ognl:ognl:3.3.4"
        self.assertRaises(OgnlException, compile, expression, self.dataRoot)

if __name__ == "__main__":
    unittest.main(testRunner=xmlrunner.XMLTestRunner(output='target/test-reports'))
