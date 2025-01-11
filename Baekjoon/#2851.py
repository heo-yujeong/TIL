m_jumsu = [int(input()) for _ in range(10)]
score = 0

for m in m_jumsu:
    score += m

    if score >= 100:
        if score - 100 > 100 - (score-m):
            score -= m
            break

print(score)