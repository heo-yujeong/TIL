import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
labor = [list(map(int, input().split())) for _ in range(N)]
virus = []
non_virus = []

# 실험실 순회하면서 바이러스 위치(2), 바이러스 없는 위치 저장(0)
# 바이러스 없는 곳 중에 3곳 조합해서 벽 세우기(1) => labor 따로 저장해서 바꿔주기!
# bfs로 방문할 수 있는 곳들 체크
# 모두 다 돌고도 0인곳 count 하고, 가장 max인 count 결과로!