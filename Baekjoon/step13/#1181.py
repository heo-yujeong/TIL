N = int(input())
word = [input() for _ in range(N)]
word = list(set(word))
word.sort(key=lambda x:(len(x), x))
for w in word:
    print(w)