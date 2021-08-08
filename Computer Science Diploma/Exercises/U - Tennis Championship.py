import sys

def process(x):
    x = int(x)
    if x != 0:
        x -= 1
    print('{}'.format(x))

def solve(inputs):
    for x in inputs:
        if " " in x:
            x.split(" ")
        process(x)

inputs = sys.stdin.readlines()
solve(inputs)