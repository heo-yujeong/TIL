week = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
day = 0

x, y = map(int, input().split())

for i in range(x-1):
    day += month[i]

result = (day + y) % 7
print(week[result])