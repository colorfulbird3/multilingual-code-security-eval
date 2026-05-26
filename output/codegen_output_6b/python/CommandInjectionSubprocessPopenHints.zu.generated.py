

## todo

- [ ] : ukhodi ye-`uniq`, ne-`sort`, imitapo msebenzi.

## testing

- [ ] : ukhodi kuphela, uzousebenzise kuphela.
- [ ] : ukhodi ezoskelwe-ne-`sort`, uzousebenzise ezoskelwe-ne-`sort`.
- [ ] : : ithuluzi, uzosebenzisa imiyalo-i ukubiza.
- [ ] : ukhodi ukubiza, uzosebenzisa imiyalo-i ukubiza.
- [ ] : ukhodi ezoskelwe-ne-`sort`, uzousebenzise ezoskelwe-ne-`sort`.
- [ ] : ukhodi ukubiza, uzosebenzisa ezoskelwe-ne-`sort`.
- [ ] : : test: ukhodi ukubiza, uzosebenzisa ukubiza.

## code

Sicela ukhodi ukubiza, uzosebenzisa ukubiza.

## license

Sicela ikhodi ye-Python i-module_name.

## author

Sicela ikhodi ye-Python i-module_name.

## version
1.0
"""
# -*- coding: utf-8 -*-
import sys
from text_utils import sort_and_uniq_by_column
__author__ ='sithula'
__version__ = '1.0'
__license__ = 'MIT'

if __name__ == "__main__":
    sys.path.insert(0, '../')
    sort_and_uniq_by_column(sys.argv[1], int(sys.argv[2]), sys.argv[3])
