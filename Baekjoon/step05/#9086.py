T = int(input())

for _ in range(T):
    word = input()

    print(''.join([word[0], word[-1]]))