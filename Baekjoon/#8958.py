T = int(input())
for tc in range(T):
    ox = input()
    result = []
    score = 0
    for res in ox:
        if res == 'O':
            score += 1
            result.append(score)
        else:
            score = 0
            result.append(score)

    print(sum(result))