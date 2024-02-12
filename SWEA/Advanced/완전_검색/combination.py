# an[] : n개의 원소를 가지고 있는 리스트
# tr[] : 조합이 임시 저장될 r개의 크기의 리스트

def comb(n, r):
    if r == 0:
        print(tr)
    elif n < r:
        return
    else:
        tr[r-1] = an[n-1]
        comb(n-1, r-1)
        comb(n-1, r)


# 라이브러리를 활용한 조합
import itertools
an = ['A', 'B', 'C', 'D', 'E']
result = itertools.combinations(an, r=3) # r 생략 불가
print(list(result))


tr = [0] * 3
comb(5, 3)