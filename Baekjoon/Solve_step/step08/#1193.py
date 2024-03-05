N = int(input())

line = 1
while N > line:
    N -= line
    line += 1

if line % 2 == 0:
    up_num = N
    bo_num = line - N + 1
else:
    up_num = line - N + 1
    bo_num = N

print(f'{up_num}/{bo_num}')