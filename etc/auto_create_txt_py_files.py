# 파일 제목 입력 시 자동으로 폴더와 #3197_No.py 파일, 폴더 내 비어있는 txt 파일 생성하는 프로그램
# 사용 방법 : 원하는 폴더에서 해당 파일 실행 -> 파일 이름 입력

import os

# 현재 경로
current_dir = os.getcwd()

# 여러 파일 한번에 생성
# 파일 이름 입력(이름 사이 space주기)
file_names = list(input('file names : ').split())

for n_file in range(len(file_names)):
    # 이미 폴더를 만든 상태이면 제외!
    if os.path.exists(file_names[n_file]):
        continue
    else:
        os.mkdir(file_names[n_file])
        # 파이썬 실행파일 생성
        f = open(f'{current_dir}/{file_names[n_file]}/solution.py', 'w')
        f.write('import sys\nsys.stdin = open("input.txt")\n')
        f.close()
        # input.txt 파일 생성
        f = open(f'{current_dir}/{file_names[n_file]}/input.txt', 'w')
        f.close()