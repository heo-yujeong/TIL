number = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'

N, B = input().split()
num_10 = 0

for i in range(len(N)):
    num_10 += number.index(N[-i-1]) * int(B) ** i

print(num_10)