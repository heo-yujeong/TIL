N = int(input())
pi = list(map(int, input().split()))
height = 0
max_height = 0

for i in range(N-1):
    if pi[i] < pi[i+1]:
        height += (pi[i+1] - pi[i])
    else:
        max_height = max(height, max_height)
        height = 0

max_height = max(height, max_height)
print(max_height)