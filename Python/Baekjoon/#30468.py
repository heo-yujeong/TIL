STR, DEX, INT, LUK, N = map(int, input().split())
total = STR + DEX + INT + LUK

if total < 4 * N:
    print(4 * N - total)
else:
    print(0)