number = set(range(1, 10000))
not_self = set()

for num in number:
    for n in str(num):
        num += int(n)
    not_self.add(num)

self_num = number - not_self
for num in sorted(self_num):
    print(num)