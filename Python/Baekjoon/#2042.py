import sys
input = sys.stdin.readline

def make_tree(start, end, idx):
    if start == end:
        seg_tree[idx] = num[start]
        return seg_tree[idx]

    mid = (start + end) // 2
    seg_tree[idx] = make_tree(start, mid, idx*2) + make_tree(mid+1, end, idx*2+1)
    return seg_tree[idx]

def find(start, end, idx, left, right):
    if start > right or end < left:
        return 0

    if start >= left and end <= right:
        return seg_tree[idx]

    mid = (start + end) // 2
    sub_sum = find(start, mid, idx*2, left, right) + find(mid+1, end, idx*2+1, left, right)
    return sub_sum

def update(start, end, idx, update_idx, update_val):
    if start == end == update_idx:
        seg_tree[idx] = update_val
        return

    if start > update_idx or end < update_idx:
        return

    mid = (start + end) // 2
    update(start, mid, idx*2, update_idx, update_val)
    update(mid+1, end, idx*2+1, update_idx, update_val)
    seg_tree[idx] = seg_tree[idx*2] + seg_tree[idx*2+1]


N, M, K = map(int, input().split())
num = [int(input()) for _ in range(N)]
seg_tree = [0 for _ in range(4*N)]

make_tree(0, N-1, 1)

for _ in range(M + K):
    a, b, c = map(int, input().split())
    if a == 1:
        update(0, N-1, 1, b-1, c)
    else:
        print(find(0, N-1, 1, b-1, c-1))