cro_alpha = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()

for cro in cro_alpha:
    word = word.replace(cro, '#')

print(len(word))