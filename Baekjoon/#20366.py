import sys
input = sys.stdin.readline

N = int(input())
snow = list(map(int, input().split()))
snow.sort()
min_diff = abs((snow[3]+snow[0]) - (snow[1]+snow[2]))

for i in range(N-3):
    for j in range(i+3, N):
        anna = snow[i] + snow[j]

        left, right = i+1, j-1
        while left < right:
            elsa = snow[left] + snow[right]
            min_diff = min(abs(anna-elsa), min_diff)

            if anna < elsa:
                right -= 1
            else:
                left += 1

print(min_diff)