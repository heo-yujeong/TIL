# 집 -> 학교
a = int(input())
# 학교 -> PC
b = int(input())
# PC -> 학원
c = int(input())
# 학원 -> 집
d = int(input())

total = a + b + c + d

print(total // 60)
print(total % 60)