N, Q = map(int, input().split())
result = []

for i in range(N):
    for b in range(int(input())):
        result.append(i+1)

for _ in range(Q):
    print(result[int(input())])