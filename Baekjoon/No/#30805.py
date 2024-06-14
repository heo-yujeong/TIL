import sys
input = sys.stdin.readline

def backtrack(idx_a, idx_b, current_lcs):
    if idx_a == N or idx_b == M:
        all_lcs.add(tuple(current_lcs))
        return

    if A[idx_a] == B[idx_b]:
        backtrack(idx_a + 1, idx_b + 1, current_lcs + [A[idx_a]])

    backtrack(idx_a + 1, idx_b, current_lcs)
    backtrack(idx_a, idx_b + 1, current_lcs)

N = int(input().strip())
A = list(map(int, input().strip().split()))
M = int(input().strip())
B = list(map(int, input().strip().split()))

all_lcs = set()
backtrack(0, 0, [])
all_lcs = sorted(list(all_lcs))

print(len(all_lcs[-1]))
print(*all_lcs[-1])