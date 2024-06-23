group = 1

while True:
    n = int(input())
    if n == 0:
        break
    message = []
    for _ in range(n):
        msg = input().split()
        message.append(msg)

    print(f'Group {group}')
    flag = True
    for i in range(n):
        if 'N' in message[i][1:]:
            flag = False
            for j in range(1, n):
                if message[i][j] == 'N':
                    print(f'{message[i-j][0]} was nasty about {message[i][0]}')
    if flag:
        print('Nobody was nasty')
    print()
    group += 1