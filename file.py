string = 'My name is vikesh Kumar'
rev=""
s=""
i=0
for x in string:
    if x!=" ":
        rev=rev+x
    else:
        length=len(rev)-1
        while length>=0:
            s=s+rev[length]
            length=length-1
        rev=""
        s=s+" "
length=len(rev)-1
while length>=0:
        s=s+rev[length]
        length=length-1
        
print(s)
        