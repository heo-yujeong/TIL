# 방향 : 1(위), 2(아래), 3(오른쪽), 4(왼쪽)
dx = [0, 0, 0, 1, -1]
dy = [0, -1, 1, 0, 0]

R, C, M = map(int, input().split())
shark = {}
max_shark = 0
for i in range(1, M+1):
    # 행, 열, 속력, 방향, 크기
    r, c, s, d, z = map(int, input().split())
    shark[(r, c)] = [s, d, z]
    max_shark += z

hap_shark = 0
idx = 0

if C <= M:
    hap_shark = max_shark
else:
    while idx < C:
        new_shark = {}
        # 사람 이동, 상어 이동
        idx += 1
        
        # 상어 여러개 겹쳐지면 하나로 합치기

        # 가장 가까운 하나 없애기
        for key, value in new_shark:
            if len(value) >= 2:
                value.sort(key=lambda x: x[z], reverse=True)
                new_shark[key] = value[0]
        
        shark = new_shark

print(hap_shark)