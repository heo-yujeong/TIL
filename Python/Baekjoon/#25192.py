N = int(input())
chat = set()
cnt = 0

for i in range(N):
    chr = input()
    if chr == 'ENTER':
        cnt += len(chat)
        chat = set()
    else:
        chat.add(chr)

cnt += len(chat)
print(cnt)