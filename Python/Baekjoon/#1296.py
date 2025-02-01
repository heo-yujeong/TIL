ename = input()
N = int(input())
team_lst = sorted([input() for _ in range(N)])

max_p = max_i = 0

for i in range(N):
    L = ename.count('L') + team_lst[i].count('L')
    O = ename.count('O') + team_lst[i].count('O')
    V = ename.count('V') + team_lst[i].count('V')
    E = ename.count('E') + team_lst[i].count('E')
    p = ((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100

    if p > max_p:
        max_p = p
        max_i = i

print(team_lst[max_i])