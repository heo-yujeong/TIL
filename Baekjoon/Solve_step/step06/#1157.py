word = input().upper()

counts = {}

for text in word:
    counts[text] = counts.get(text, 0) + 1

max_counts = []
for k, v in counts.items():
    if max(counts.values()) == counts[k]:
        max_counts.append(k)

if len(max_counts) >= 2:
    print('?')
else:
    print(max_counts[0])