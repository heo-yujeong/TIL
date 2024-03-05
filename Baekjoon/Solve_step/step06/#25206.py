gra_score = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0}

total_hap = 0
score_hap = 0

for _ in range(20):
    sub, score, grade = input().split()

    if grade == 'P':
        continue
    else:
        score_hap += float(score)
        total_hap += (float(score) * gra_score[grade])

print(total_hap / score_hap)