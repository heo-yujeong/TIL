# a[] : 데이터가 저장된 리스트
# n: 원소의 개수, k: 현재까지 선택된 원소의 수

def perm(n, k):
    if k == n: # 하나의 순열 생성
        print(a)
    else:
        for i in range(k, n):
            a[k], a[i] = a[i],a[k]
            perm(n, k+1)
            a[k], a[i] = a[i],a[k]


# 라이브러리를 활용한 순열
import itertools
a = [1, 2, 3]
result = itertools.permutations(a) # mylist, 3
# 리스트의 크기만큼 순열 만들때 생략 가능
print(list(result))

perm(3, 0)