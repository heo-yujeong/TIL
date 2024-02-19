N, B = map(int, input().split())

num_B = ''
number = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'

while N:
    num_B += str(number[N % B])
    N //= B

print(num_B[::-1])