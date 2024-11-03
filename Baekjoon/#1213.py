name = input()
count = {}
keys = sorted(list(set(name)))
odd = []

for k in keys:
    cnt = name.count(k)
    count[k] = cnt

    if cnt % 2:
        odd.append(k)

if len(odd) > 1:
    print("I'm Sorry Hansoo")
else:
    result = ''
    for k in keys:
        result += k * (count[k] // 2)

    if odd:
        result += odd[0] + result[::-1]
    else:
        result += result[::-1]

    print(result)