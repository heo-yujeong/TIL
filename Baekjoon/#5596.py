S = T = 0
s = list(map(int, input().split()))
t = list(map(int, input().split()))

S = sum(s)
T = sum(t)

if S > T:
    print(S)
elif S == T:
    print(S)
else:
    print(T)