import sys
input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))

nums = [-1] * 1000001
for idx, card in enumerate(cards):
    nums[card] = idx

scores = [0] * N

for i in range(1000001):
    if nums[i] > -1:
        for j in range(i*2, 1000001, i):
            if nums[j] > -1:
                scores[nums[i]] += 1
                scores[nums[j]] -= 1

print(*scores)