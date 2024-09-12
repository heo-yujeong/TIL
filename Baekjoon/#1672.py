DNA = {
    'AA': 'A',
    'AG': 'C',
    'AC': 'A',
    'AT': 'G',
    'GA': 'C',
    'GG': 'G',
    'GC': 'T',
    'GT': 'A',
    'CA': 'A',
    'CG': 'T',
    'CC': 'C',
    'CT': 'G',
    'TA': 'G',
    'TG': 'A',
    'TC': 'G',
    'TT': 'T'
}

N = int(input())
S = list(input())

for i in range(N-2, -1, -1):
    S[i] = DNA[S[i]+S[i+1]]

print(S[0])