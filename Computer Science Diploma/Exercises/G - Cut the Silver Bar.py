import sys
import math

def process(x):
    if x == 0:
        return
    else:
        print(int(math.log(x, 2)))
        
def solve(inputs):
    for x in inputs:
        process(int(x))

inputs = sys.stdin.readlines()
solve(inputs)