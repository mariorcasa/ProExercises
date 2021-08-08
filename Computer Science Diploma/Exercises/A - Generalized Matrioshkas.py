import sys

def process(x):
    array = []
    arraydict = {}
    res = True
    for y in x:
        if y > 0:
            if (arraydict.get(len(array), 0) >= y) or not (len(array) > 0 and array[-1] == -y):
                res = False
                break
            arraydict[len(array)] = 0
            del array[-1]
            arraydict[len(array)] = y + arraydict.get(len(array), 0)
        else:
            array.append(y)
    if len(array) == 0 and res:
        print(":-) Matrioshka!")
    else: 
        print(":-( Try again.")

def solve(inputs):
    for x in inputs:
        process(map(int, x.split(" ")))

inputs = sys.stdin.readlines()
solve(inputs)