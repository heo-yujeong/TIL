import sys
from heapq import heappush, heappop

T = int(sys.stdin.readline())
for _ in range(T):
    min_pq = []
    max_pq = []
    k = int(sys.stdin.readline())
    check = [1] * k
    for idx in range(k):
        oper, num = sys.stdin.readline().split()
        if oper == 'I':
            heappush(max_pq, (-int(num), idx))
            heappush(min_pq, (int(num), idx))
        else:
            if int(num) == 1:
                for i in range(len(max_pq)):
                    if max_pq and not check[max_pq[0][1]]:
                        heappop(max_pq)
                    else:
                        break
                if max_pq:
                    check[max_pq[0][1]] = 0
                    heappop(max_pq)
            else:
                for i in range(len(min_pq)):
                    if min_pq and not check[min_pq[0][1]]:
                        heappop(min_pq)
                    else:
                        break
                if min_pq:
                    check[min_pq[0][1]] = 0
                    heappop(min_pq)

    for i in range(len(max_pq)):
        if max_pq and not check[max_pq[0][1]]:
            heappop(max_pq)
        else:
            break
    for i in range(len(min_pq)):
        if min_pq and not check[min_pq[0][1]]:
            heappop(min_pq)
        else:
            break

    if min_pq and max_pq:
        print(-heappop(max_pq)[0], heappop(min_pq)[0])
    else:
        print('EMPTY')