# 자동으로 .venv 폴더 삭제 해주는 코드

import os
import subprocess

current_folder = os.getcwd()

for foldername, subfolders, filenames in os.walk(current_folder):
    if 'venv' in subfolders:
        idea_folder_path = os.path.join(foldername, 'venv')
        subprocess.run(['rm', '-rf', idea_folder_path])
        print(f'{idea_folder_path} 폴더가 삭제되었습니다.')