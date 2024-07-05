import sys
input = sys.stdin.readline

def cal_max_power(days_left, current_level, used):
    if current_level == N-1:
        return 0
    if dp[days_left][current_level][used] != -1:
        return dp[days_left][current_level][used]

    max_possible = min(used + cnt_level[current_level], days_left)
    max_power = 0
    for cnt in range(max_possible + 1):
        power = (power_level[current_level+1]-power_level[current_level]) * cnt
        max_power = max(max_power, cal_max_power(days_left-cnt, current_level+1, cnt) + power)
  
    dp[days_left][current_level][used] = max_power
    return max_power

N = int(input())
cnt_level = list(map(int, input().split()))
power_level = list(map(int, input().split()))
D = int(input())

hap_power = sum(cnt_level[i]*power_level[i] for i in range(N))
dp = [[[-1] * (D+1) for _ in range(N)] for  _ in range(D+1)]

print(hap_power + cal_max_power(D, 0, 0))