import sys
input = sys.stdin.readline

def backtrack(cnt, oper_result):
    if cnt == N-1:
        result.append(oper_result)
        return

    for i in range(4):
        if oper_cnt[i] > 0:
            oper_cnt[i] -= 1
            if i == 0:
                backtrack(cnt+1, oper_result+A[cnt+1])
            elif i == 1:
                backtrack(cnt+1, oper_result-A[cnt+1])
            elif i == 2:
                backtrack(cnt+1, oper_result*A[cnt+1])
            else:
                if oper_result >= 0:
                    backtrack(cnt+1, oper_result//A[cnt+1])
                else:
                    backtrack(cnt+1, -(-oper_result//A[cnt+1]))
            oper_cnt[i] += 1

N = int(input())
A = list(map(int, input().split()))
oper_cnt = list(map(int, input().split()))

result = []

backtrack(0, A[0])

print(max(result))
print(min(result))