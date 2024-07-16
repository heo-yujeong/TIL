import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

def preorder(in_start, in_end, post_start, post_end):
    if in_start > in_end or post_start > post_end:
        return

    root = postorder[post_end]
    print(root, end=' ')

    left = node[root] - in_start
    right = in_end - node[root]

    preorder(in_start, in_start+left-1, post_start, post_start+left-1)
    preorder(in_end-right+1, in_end, post_end-right, post_end-1)

n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))

node = [0] * (n+1)
for i in range(n):
    node[inorder[i]] = i

preorder(0, n-1, 0, n-1)