import sys
input = sys.stdin.readline

N = int(input())
stack = []
total_score = 0

for _ in range(N):
    assign = input().split()
    if assign[0] == '1':
        if assign[2] == '1':
            total_score += int(assign[1])
        else:
            stack.append([int(assign[1]), int(assign[2])-1])
    else:
        if stack:
            score, time = stack.pop()
            if time == 1:
                total_score += score
            else:
                stack.append([score, time-1])

print(total_score)