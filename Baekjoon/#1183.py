import sys
input = sys.stdin.readline

N = int(input())
cha_time = []
for _ in range(N):
    A, B = map(int, input().split())
    cha_time.append(A-B)

cha_time.sort()

if len(cha_time) % 2 == 0:
    print(cha_time[len(cha_time)//2] - cha_time[len(cha_time)//2-1] + 1)
else:
    print(1)