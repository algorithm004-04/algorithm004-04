#!/usr/bin/python
# -*- coding: UTF-8 -*-

import os
import sys

# arg1: path
# arg2: 学号

dirName = sys.argv[1]
schoolNum = sys.argv[-1]

for item in os.listdir(dirName):
    parts = item.split(".")
    if len(parts) > 1 and parts[0].isnumeric(): 
        os.rename(item, "LeetCode_" + str(parts[0]) + "_" + schoolNum + "." + parts[-1])






