n = int(input())
in_com = set()
for _ in range(n):
    name, status = input().split()
    if status == 'enter':
        in_com.add(name)
    else:
        in_com.remove(name)
in_com = list(in_com)
in_com.sort(reverse=True)
print(*in_com, sep='\n')