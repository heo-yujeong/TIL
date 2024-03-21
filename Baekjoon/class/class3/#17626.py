'''
1 = 1^2                     => 1
2 = 1^2 + 1^2               => 2
3 = 1^2 + 1^2 + 1^2         => 3
4 = 2^2                     => 1
5 = 2^2 + 1^2               => 2
6 = 2^2 + 1^2 + 1^2         => 3
7 = 2^2 + 1^2 + 1^2 + 1^2   => 4
8 = 2^2 + 2^2               => 2
9 = 3^2                     => 1
10 = 3^2 + 1^2              => 2
11 = 3^2 + 1^2 + 1^2        => 3
12 = 2^2 + 2^2 + 2^2        => 3
13 = 3^2 + 2^2              => 2
14 = 3^2 + 2^2 + 1^2        => 3
15 = 3^2 + 2^2 + 1^2 + 1^2  => 4
16 = 4^2                    => 1
17 = 4^2 + 1^2              => 2
18 = 3^2 + 3^2              => 2


하나작은 수 + 1 or d[n-n보다 작거나 같은 제곱수] + 1
'''

# dp
# n = int(input())
# d = [0, 1]
# for i in range(2, n+1):
#     min_cnt = 4
#     j = 1
#     while j**2 <= i:
#         min_cnt = min(min_cnt, d[i-j**2])
#         j += 1
#     d.append(min_cnt+1)
# print(d[n])

# 부르트포스
n = int(input())
arr = [0 if i**0.5%1 else 1 for i in range(n+1)]

min_cnt = 4
for i in range(int(n**0.5), 0, -1):
    if arr[n]:
        min_cnt = 1
        break
    elif arr[n-i**2]:
        min_cnt = 2
        break
    else:
        for j in range(int((n-i**2)**0.5), 0, -1):
            if arr[(n-i**2)-j**2]:
                min_cnt = 3
print(min_cnt)