from collections import deque
N = int(input())

card = deque(list(range(1, N+1)))
while len(card) > 1:
    card.popleft()
    go_end = card.popleft()
    card.append(go_end)

print(*card)