import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
balloon = deque(enumerate(map(int, input().split()), start=1))

while balloon:
    idx, num = balloon.popleft()
    print(idx, end=' ')

    if num > 0:
        balloon.rotate(-(num-1))
    else:
        balloon.rotate(-num)