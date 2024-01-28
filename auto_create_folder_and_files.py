# 자동으로 폴더 안의 .py파일의 폴더 생성 및 옮기는 프로그램
# + 폴더 내 비어있는 txt파일 생성(input.txt)

import os
import shutil

# 현재 경로
current_dir = os.getcwd()
# 현재 경로에 있는 .py형식의 파일 리스트
file_list = [_ for _ in os.listdir(current_dir) if _.endswith('.py')]


for file in file_list:
    if file == os.path.basename(__file__):
        # 파일 이름이 현재 실행 중인 파일이면 제외!
        continue
    else:
        # 확장자를 제외한 파일 이름만 추출
        file_name = os.path.splitext(file)[0]
        # 이미 폴더를 만든 상태이면 제외!
        if os.path.exists(file_name):
            continue
        else:
            # 파일 이름과 동일한 폴더 이름 생성
            os.mkdir(file_name)
            # 생성한 폴더로 파일 옮기기
            shutil.move(os.path.join(current_dir, file), os.path.join(f'{current_dir}/{file_name}', file))
            # 각 폴더마다 input.txt 파일 생성
            f = open(f'{current_dir}/{file_name}/input.txt', 'w')
            f.close()