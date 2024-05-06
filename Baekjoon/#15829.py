L = int(input())
char = input()

alpha = 'abcdefghijklmnopqrstuvwxyz'

h = 0
for i in range(L):
    h += (alpha.index(char[i])+1) * 31 ** i

print(h%1234567891)