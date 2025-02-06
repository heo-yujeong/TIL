tri = [i*(i+1)//2 for i in range(1, 46)]
eureka_num = [0] * 1001

for i in tri:
    for j in tri:
        for k in tri:
            num = i + j + k
            if num <= 1000:
                eureka_num[num] = 1

T = int(input())
for _ in range(T):
    K = int(input())
    print(eureka_num[K])