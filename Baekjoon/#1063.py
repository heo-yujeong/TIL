move_dict = {'R':[1, 0], 'L':[-1, 0], 'B':[0, -1], 'T':[0, 1],
             'RT':[1, 1], 'LT':[-1, 1], 'RB':[1, -1], 'LB':[-1, -1]}
alpha = 'ABCDEFGH'

king_loc, doll_loc, N = input().split()
king_loc = [alpha.index(king_loc[0])+1, int(king_loc[1])]
doll_loc = [alpha.index(doll_loc[0])+1, int(doll_loc[1])]

for _ in range(int(N)):
    move = input()
    king_loc[0] += move_dict[move][0]
    king_loc[1] += move_dict[move][1]
    if 1 <= king_loc[0] <= 8 and 1 <= king_loc[1] <= 8:
        if king_loc == doll_loc:
            doll_loc[0] += move_dict[move][0]
            doll_loc[1] += move_dict[move][1]
            if 1 <= doll_loc[0] <= 8 and 1 <= doll_loc[1] <= 8:
                continue
            else:
                king_loc[0] -= move_dict[move][0]
                king_loc[1] -= move_dict[move][1]
                doll_loc[0] -= move_dict[move][0]
                doll_loc[1] -= move_dict[move][1]
    else:
        king_loc[0] -= move_dict[move][0]
        king_loc[1] -= move_dict[move][1]

print(alpha[king_loc[0]-1] + str(king_loc[1]))
print(alpha[doll_loc[0]-1] + str(doll_loc[1]))