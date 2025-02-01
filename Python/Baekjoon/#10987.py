word = input()
cnt = 0
for w in word:
    if w in 'aeiou':
        cnt += 1

print(cnt)