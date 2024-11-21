n = input()

if len(n) == 2:
    print(int(n[0]) + int(n[1]))
elif len(n) == 3:
    n = n.replace('10','')
    print(10+int(n))
else:
    print(20)