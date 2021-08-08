import sys

def process(x):
    a = int(x[0])
    b = int(x[1])
    res = None
    if a == 0 and b == 0:
        return
    w = int(((a*a)+1) / 2)
    x = a*a - b
    y = int(((a-2)*(a-2) +1) /2)
    z = (a-2)*(a-2) - y
    if b <= w:
        res = 4*b
    elif x <= y:
        res = 4*(a+x)
    else:
        res = 4*(a+y) + (2 * min(x-y, 4*(int(a/2) -1)))
        if a%2 != 0:
            res = max(res, 4*(a+z) + 2*(x-z))
    print(res)

def solve(inputs):
    for x in inputs:
        process(x.split(" "))

inputs = sys.stdin.readlines()
solve(inputs)