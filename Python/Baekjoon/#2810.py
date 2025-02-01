N = int(input())
seat = input()
couple = seat.count('LL')

if couple <= 1:
    print(N)
else:
    print(N - couple + 1)