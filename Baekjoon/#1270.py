import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    T, *numbers = map(int, input().split())
    count = {}

    for num in numbers:
        if num in count:
            count[num] += 1
        else:
            count[num] = 1

    max_num = max(count, key=count.get)
    if count[max_num] > T//2:
        print(max_num)
    else:
        print('SYJKGW')