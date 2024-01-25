# 리스트 초기화
arr = [0, 0, 0, 0, 0]
arr = [0] * 5
arr = [i for i in range(2, 9) if i % 2 == 0] # [2, 4, 6, 8]

brr = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
brr = [[1, 2, 3]] * 3
brr = [[1, 2, 3] for i in range(3)]


# 2차원 리스트 입력 받기
n, m = map(int, input().split())

mylist = [0 for _ in range(n)]
for i in range(n):
    mylist[i] = list(map(int, input().split()))


mylist = []
for i in range(n):
    mylist.append(list(map(int, input().split())))


mylist = [list(map(int, input().split())) for _ in range(n)]


# 주어진 데이터에서 1이 입력된 [행, 열]의 위치 찾기
newlist = []
mylist = [list(map(int, input().split())) for _ in range(n)]
for i in range(n):
    for j in range(m):
        if mylist[i][j] == 1:
            newlist.append([i, j])


newlist = [(i, j) for i in range(n) for j in range(m) if mylist[i][j] == 1]


# list를 지그재그로 순회
n = len(arr) # i : 행의 좌표
m = len(arr[0]) # j : 열의 좌표

for i in range(len(arr)):
    for j in range(len(arr[0])):
        arr[i][j + (m - 1 - 2 * j) * (i % 2)]


# 전치행렬 : zip(*matrix)
        

# 어떤 집합의 부분 집합을 구할 경우 부분집합의 총 개수
# = 집합의 원소가 n개 일 때, 2 ** n ( 모두 포함, 모두 포함하지 않는 경우 포함 )
        

# 부분집합 생성(Loop 이용)
bit = [0, 0, 0, 0]
for i in range(2):
    bit[0] = i
    for j in range(2):
        bit[1] = j
        for k in range(2):
            bit[2] = k
            for l in range(2):
                bit[3] = l
                print(bit)


# 1 << n : 2 ** n => 원소가 n개일 경우의 모든 부분 집합의 수
# i & (1 << j) : 1 => i에서 j번째 비트가 1인지 아닌지를 리턴
                

# 부분집합 생성2
arr = [3, 6, 7, 1, 5, 4]
n = len(arr) # 원소의 개수

for i in range(1 << n): # 1 << n : 부분집합의 개수
    for j in range(n):
        if i & (1 << j): # i의 j번째 비트가 1이면 j번째 원소 출력
            print(arr[j], end=',')
    print()


# 이진검색
def binarySearch(a, key):
    start = 0
    end = len(a) - 1
    while start <= end:
        middle = start + (end - start) // 2
        if key == a[middle]: # 검색 성공
            return True
        elif key < a[middle]:
            end = middle - 1
        else:
            start = middle + 1
    return False


def binarySearch2(a, low, high, key):
    if low > high: # 검색 실패
        return False
    else:
        middle = (low + high) // 2
        if key == a[middle]: # 검색 성공
            return True
        elif key < a [middle]:
            return binarySearch2(a, low, middle-1, key)
        elif a[middle] < key:
            return binarySearch2(a, middle + 1, high, key)