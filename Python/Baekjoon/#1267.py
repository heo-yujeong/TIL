N = int(input())
times = list(map(int, input().split()))
yc = mc = 0

for time in times:
    yc += (time//30 + 1) * 10
    mc += (time//60 + 1) * 15

if yc == mc:
    print("Y M", mc)
elif yc > mc:
    print("M", mc)
else:
    print("Y", yc)