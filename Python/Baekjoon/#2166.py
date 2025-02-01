import sys
input = sys.stdin.readline

N = int(input())
figure = [list(map(int, input().split())) for _ in range(N)]
figure.append(figure[0])

result = 0
for i in range(N):
    result += (figure[i][0]*figure[i+1][1] - figure[i+1][0]*figure[i][1])

print(abs(result)/2)