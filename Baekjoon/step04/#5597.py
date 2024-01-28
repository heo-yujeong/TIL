student = [0 for _ in range(31)]

for i in range(28):
    student[int(input())] = 1

first, second = [idx + 1 for idx, value in enumerate(student[1:]) if value == 0]
print(first)
print(second)