N = int(input())
window = 0
for i in range(1, N+1):
    if i**2 <= N:
        window += 1
    else:
        break

print(window)