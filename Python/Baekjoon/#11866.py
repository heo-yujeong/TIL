from collections import deque
N, K = map(int, input().split())

queue = deque(list(range(1, N+1)))
result = []

while queue:
    queue.rotate(-(K-1))
    result.append(queue.popleft())

print('<', end='')
for i in range(len(result)):
    if i == len(result)-1:
        print(f'{result[i]}>')
    else:
        print(f'{result[i]},', end=' ')