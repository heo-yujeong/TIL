# 이항계수가 뭔데........
# 그게 뭐하는건데.....
n, k = map(int, input().split())
n1 = n2 = n3 = 1
for i in range(1, n+1):
    n1 *= i

for j in range(1, n-k+1):
    n2 *= j

for l in range(1, k+1):
    n3 *= l

result = n1//(n2*n3)
print(result)
# 해드렷읍니다...
# 고마워 원아,...