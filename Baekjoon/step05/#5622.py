alpa_num = ['', '', 'ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
word = input()
result = 0

for al_num in alpa_num:
    for text in word:
        if text in al_num:
            result += (alpa_num.index(al_num) + 1)

print(result)