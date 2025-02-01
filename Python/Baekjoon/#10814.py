N = int(input())
member = []
for idx in range(N):
    age, name = input().split()
    member.append([idx, int(age), name])
member.sort(key=lambda x:(x[1], x[0]))

for mem in member:
    print(f'{mem[1]} {mem[2]}')