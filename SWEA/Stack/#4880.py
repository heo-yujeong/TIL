def div_group(start, end):
    if start == end:
        return start

    a = div_group(start, (start+end)//2)
    b = div_group((start+end)//2 + 1, end)
    return play(a, b)

def play(mem1, mem2):
    if card[mem1] == card[mem2]:
        return mem1
    elif card[mem1] - card[mem2] in [1, -2]:
        return mem1
    return mem2

T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    card = list(map(int, input().split()))

    result = div_group(0, N-1) + 1

    print(f'#{test_case} {result}')