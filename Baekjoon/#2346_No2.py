import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
balloon = deque(enumerate(map(int, input().split()), start=1))

visit = [0] * N
