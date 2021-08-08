import sys

def process(x):
    l = int(x[0])
    #Initial state
    sta = ['+','x']
    count = 1
    for dire in x[1].split(" "):
        if dire == "No":
            None
        elif "".join(sta) == "+x": 
            sta = list(dire)
        elif "".join(sta) == "-x":
            if dire[0] == "+":
                sta[0] = "-"
                sta[1] = dire[1]
            else:
                sta[0] = "+"
                sta[1] = dire[1]
        elif "".join(sta) == "+y" and dire[1] == "y":
            if dire[0] == "+":
                sta[0] = "-"
                sta[1] = "x"
            else:
                sta[0] = "+"
                sta[1] = "x"
        elif "".join(sta) == "-y" and dire[1] == "y":
            if dire[0] == "+":
                sta[0] = "+"
                sta[1] = "x"
            else:
                sta[0] = '-'
                sta[1] = "x"
        elif "".join(sta) == "+z" and dire[1] == "z":
            if dire[0] == "+":
                sta[0] = "-"
                sta[1] = "x"
            else:
                sta[0] = "+"
                sta[1] = "x"
        elif "".join(sta) == "-z" and dire[1] == "z":
            if dire[0] == "+":
                sta[0] = "+"
                sta[1] = "x"
            else:
                sta[0] = "-"
                sta[1] = "x"
        count +=1
    print("".join(sta))

def solve(inputs):
    counter = 0
    arrayobj = []
    for x in inputs:
        arrayobj.append(x.replace("\n", ""))
        if counter == 1:
            process(arrayobj)
            counter -= 2
            arrayobj = []
        counter += 1 

inputs = sys.stdin.readlines()
solve(inputs)