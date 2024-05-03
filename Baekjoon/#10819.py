import sys
input = sys.stdin.readline

def backtrack(lst):
    global max_hap
    if len(lst) == N:
        hap = 0
        for i in range(N-1):
            hap += abs(lst[i] - lst[i+1])
        max_hap = max(max_hap, hap)

    for i in range(N):
        if not visit[i]:
            visit[i] = 1
            lst.append(num_lst[i])
            backtrack(lst)
            visit[i] = 0
            lst.pop()

N = int(input())
num_lst = list(map(int, input().split()))
visit = [0] * N

max_hap = 0
backtrack([])
print(max_hap)