S = input()
bubun = set()

for i in range(len(S)):
    for j in range(i, len(S)):
        bubun.add(S[i:j+1])

print(len(bubun))