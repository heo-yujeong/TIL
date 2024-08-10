import sys
input = sys.stdin.readline

N = int(input())
num_people = list(map(int, input().split()))

order = [0] * N

for i in range(N):
    cnt = 0
    for j in range(N):
        if cnt == num_people[i] and order[j] == 0:
            order[j] = i+1
            break
        elif order[j] == 0:
            cnt += 1

print(*order)