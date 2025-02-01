people = 0
train = []

for i in range(1,11):
    out_people, in_people = map(int, input().split())
    people = people - out_people + in_people
    train.append(people)

print(max(train))