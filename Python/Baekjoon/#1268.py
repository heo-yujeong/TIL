n = int(input())
student_class = [list(map(int, input().split())) for _ in range(n)]
same_class = [[0] * n for _ in range(n)]

for grade in range(5):
    for i in range(n):
        for j in range(i+1, n):
            if student_class[i][grade] == student_class[j][grade]:
                same_class[i][j] = 1
                same_class[j][i] = 1

count = []
for same in same_class:
    count.append(same.count(1))

print(count.index(max(count)) + 1)