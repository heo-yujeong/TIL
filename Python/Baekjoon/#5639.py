import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def postorder(start, end):
    if start > end:
        return
    root = end + 1
    for i in range(start+1, end+1):
        if preorder[i] > preorder[start]:
            root = i
            break

    postorder(start+1, root-1)
    postorder(root, end)
    print(preorder[start])

preorder = []
while True:
    try:
        preorder.append(int(input()))
    except:
        break

postorder(0, len(preorder)-1)