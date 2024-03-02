N, M = map(int, input().split())
not_hear = set(input() for _ in range(N))
not_see = set(input() for _ in range(M))

not_hear_see = sorted(list(not_see.intersection(not_hear)))
print(len(not_hear_see))
print(*not_hear_see, sep='\n')