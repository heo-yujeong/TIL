change = 1000 - int(input())
cnt = 0

for coin in [500, 100, 50, 10, 5, 1]:
    cnt += change // coin
    change %= coin

print(cnt)