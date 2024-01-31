T = int(input())

# 방법 1
def function(N):
    if N % 10 == 0:
        if N == 10:
            return 1
        elif N == 20:
            return 3
        else:
            return function(N-10) + (2 * function(N-20))


for test_case in range(1, T+1):
    N = int(input())
    count = function(N)
    print(f'#{test_case} {count}')



# 방법 2
# count = [0, 1, 3]
# for test_case in range(1, T+1):
#     N = int(input()) // 10

#     while N >= len(count):
#         count.append(count[len(count) - 2] * 2 + count[len(count) - 1])

#     print(f'#{test_case} {count[N]}')