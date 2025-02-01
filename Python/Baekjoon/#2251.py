from collections import deque

def pour(a, b):
    if not visit[a][b]:
        visit[a][b] = 1
        queue.append((a, b))

A, B, C = map(int, input().split())

queue = deque()
queue.append((0, 0))

visit = [[0] * (B+1) for _ in range(A+1)]
visit[0][0] = 1

answer = []

while queue:
    a, b = queue.popleft()
    c = C - a - b

    if a == 0:
        answer.append(c)

    # A -> B
    water = min(a, B-b)
    pour(a-water, b+water)
    # A -> C
    water = min(a, C-c)
    pour(a-water, b)
    # B -> C
    water = min(b, C-c)
    pour(a, b-water)
    # B -> A
    water = min(b, A-a)
    pour(a+water, b-water)
    # C -> A
    water = min(c, A-a)
    pour(a+water, b)
    # C -> B
    water = min(c, B-b)
    pour(a, b+water)

answer.sort()
print(*answer)