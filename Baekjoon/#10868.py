import sys
input = sys.stdin.readline

def init(start, end, index):
    if start == end:
        tree[index] = data[start]
        return tree[index]

    mid = (start + end) // 2
    tree[index] = min(init(start, mid, index * 2), init(mid + 1, end, index * 2 + 1))
    return tree[index]

def find(start, end, index, left, right):
    if left > end or right < start:
        return 1000000000 * (right-left+1)

    if left <= start and end <= right:
        return tree[index]

    mid = (start + end) // 2
    return min(find(start, mid, index * 2, left, right), find(mid + 1, end, index * 2 + 1, left, right))

N, M = map(int, input().split())
data = [0] + [int(input()) for _ in range(N)]
tree = [0] * (N*4)

init(1, N, 1)
for _ in range(M):
    a, b = map(int, input().split())
    print(find(1, N, 1, a, b))