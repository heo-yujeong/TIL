docs = input()
word = input()

i, cnt = 0, 0

while i <= len(docs)-len(word):
    if docs[i:i+len(word)] == word:
        i += len(word)
        cnt += 1
    else:
        i += 1

print(cnt)