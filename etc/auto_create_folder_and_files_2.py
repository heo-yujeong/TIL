# 문제 개수 입력 시 자동으로 폴더와 .py 파일, 폴더 내 비어있는 txt 파일 생성하는 프로그램
# 사용 방법 : 원하는 폴더에서 해당 파일 실행 -> 폴더 만들고자 하는 개수 입력
# 만약, 8개 폴더 생성해야 하는데, 5개를 입력했다면 다시 실행해서 8 입력!
# => 이전 폴더 및 파일 삭제할 필요X

import os

# 파일 개수 입력
number_of_files = int(input('How many questions are there? : '))
# 현재 경로
current_dir = os.getcwd()

for n_file in range(number_of_files):
    # 입력한 파일 개수로 폴더명 (ex- 0001_practice)
    folder_name = '%04d' % (n_file+1) + '_practice'
    # 이미 폴더를 만든 상태이면 제외!
    if os.path.exists(folder_name):
        continue
    else:
        # 폴더 만들기
        os.mkdir(folder_name)
        # 파이썬 실행파일 생성
        f = open(f'{current_dir}/{folder_name}/{folder_name}.py', 'w')
        f.close()
        # input.txt 파일 생성
        f = open(f'{current_dir}/{folder_name}/input.txt', 'w')
        f.close()