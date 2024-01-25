T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    cards = list(input())

    card_count = [0 for _ in range(10)]
    
    num = 0
    count = 0

    for card in cards:
        card_count[int(card)] += 1
    
    for c in range(len(card_count)-1, -1, -1):
        if card_count[c] == max(card_count):
            num = c
            count = card_count[c]
            break
    
    print(f'#{test_case} {num} {count}')