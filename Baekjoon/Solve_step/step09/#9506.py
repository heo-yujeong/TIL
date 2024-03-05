while True:
    n = int(input())
    if n == -1:
        break
    else:
        yaksu = []
        for i in range(1, n):
            if n % i == 0:
                yaksu.append(i)

        if sum(yaksu) == n:
            print(f'{n} =', end=' ')
            for i in range(len(yaksu)):
                if i == len(yaksu) - 1:
                    print(yaksu[i])
                else:
                    print(yaksu[i], end=' + ')
        else:
            print(f'{n} is NOT perfect.')