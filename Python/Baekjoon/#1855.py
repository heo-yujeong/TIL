K = int(input())
text = input()

arr = []

for i in range(0, len(text), K*2):
    if i + K <= len(text):
        arr.append(text[i:i+K])

    if i + (K * 2) <= len(text):
        arr.append(text[i+K:i+(K*2)][::-1])

result = ''

for i in range(K):
    for chr in arr:
        result += chr[i]

print(result)