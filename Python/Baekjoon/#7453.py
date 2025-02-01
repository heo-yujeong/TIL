# import sys
# input = sys.stdin.readline
#
# n = int(input())
# A, B, C, D = [], [], [], []
# for _ in range(n):
#     a, b, c, d = map(int, input().split())
#     A.append(a)
#     B.append(b)
#     C.append(c)
#     D.append(d)
#
# AB, CD = [], []
# for i in range(n):
#     for j in range(n):
#         AB.append(A[i]+B[j])
#         CD.append(C[i]+D[j])
#
# AB.sort()
# CD.sort()
#
# start, end = 0, n**2-1
# cnt = 0
#
# while start < len(AB) and end >= 0:
#     if AB[start] + CD[end] == 0:
#         next_start, next_end = start + 1, end - 1
#
#         while next_start < len(AB) and AB[start] == AB[next_start]:
#             next_start += 1
#
#         while next_end >= 0 and CD[end] == CD[next_end]:
#             next_end -= 1
#
#         cnt += (next_start-start) * (end-next_end)
#         start, end = next_start, next_end
#
#     elif AB[start] + CD[end] > 0:
#         end -= 1
#     else:
#         start += 1
#
# print(cnt)

# import sys
# input = sys.stdin.readline
#
# n = int(input())
# A, B, C, D = [], [], [], []
#
# for _ in range(n):
#     a, b, c, d = map(int, input().split())
#     A.append(a)
#     B.append(b)
#     C.append(c)
#     D.append(d)
#
# AB = {}
# for i in range(n):
#     for j in range(n):
#         ab = A[i] + B[j]
#         if ab in AB:
#             AB[ab] += 1
#         else:
#             AB[ab] = 1
#
# cnt = 0
# for i in range(n):
#     for j in range(n):
#         cd = C[i] + D[j]
#         target = -cd
#         if target in AB:
#             cnt += AB[target]
#
# print(cnt)

import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())
A, B, C, D = [], [], [], []

for _ in range(n):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

AB = defaultdict(int)
for i in range(n):
    for j in range(n):
        AB[A[i] + B[j]] += 1

cnt = 0
for i in range(n):
    for j in range(n):
        target = -(C[i] + D[j])
        if target in AB:
            cnt += AB[target]

print(cnt)