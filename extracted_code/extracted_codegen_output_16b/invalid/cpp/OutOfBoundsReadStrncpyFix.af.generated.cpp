import os
import sys

path = os.path.dirname(os.path.realpath(__file__))
sys.path.append(path)

import helper
import pprint

# load the helper functions
from helper import *

# load the protocol handler
import protocol_handler as ph

def main():
    # get the function we want to test
    ph.process_protocol_message = ph.get_function("process_protocol_message")

    # get the parameters of the test function
    params = get_function_parameters(ph.process_protocol_message)

    # test the function
    helper.test_function(ph.process_protocol_message, params)

# call main
if __name__ == "__main__":
    main()