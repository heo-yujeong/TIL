while True:
    txt_num = input()
    if txt_num == '0':
        break
    if txt_num == txt_num[::-1]:
        print('yes')
    else:
        print('no')