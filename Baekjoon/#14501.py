def consult_chk(day, profit):
    global max_profit
    if day == N:
        if max_profit < profit:
            max_profit = profit
        return
    if day + consult[day][0] <= N:
        consult_chk(day + consult[day][0], profit+consult[day][1])
    consult_chk(day+1, profit)


N = int(input())
consult = [list(map(int, input().split())) for _ in range(N)]
max_profit = 0

consult_chk(0, 0)

print(max_profit)