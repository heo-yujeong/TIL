month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
day = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

Month, D, Y, T = input().split()
D = int(D[:-1])
Y = int(Y)
H, M = map(int, T.split(':'))

if Y % 400 == 0 or (Y % 4 == 0 and Y % 100 != 0):
    day[1] += 1

total = sum(day) * 24 * 60
month_idx = month.index(Month)
time = (sum(day[:month_idx]) + D-1) * 24 * 60 + H * 60 + M
print(time/total * 100)