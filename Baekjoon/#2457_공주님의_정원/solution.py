import sys
sys.stdin = open('input.txt')

N = int(input())
flowers = []
for _ in range(N):
    start_m, start_d, end_m, end_d = map(int, input().split())
    flowers.append((start_m * 100 + start_d, end_m * 100 + end_d))

flowers.sort(key=lambda x : (x[0], x[1]))

cnt = 0
end = 301
target = 301

while flowers:
    if target >= 1201 or target < flowers[0][0]:
        break

    for _ in range(len(flowers)):
        if target >= flowers[0][0]:
            if end <= flowers[0][1]:
                end = flowers[0][1]

            flowers.remove(flowers[0])
        else:
            break

    target = end
    cnt += 1

if target < 1201:
    print(0)
else:
    print(cnt)