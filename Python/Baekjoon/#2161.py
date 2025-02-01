N = int(input())

queue = list(range(1, N+1))
while len(queue) > 1:
    print(queue.pop(0), end=' ')
    queue = queue[1:] + [queue[0]]

print(queue.pop())