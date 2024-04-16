h, m = map(int, input().split(' '))
x = int(input())

a = (m + x) // 60
m = (m + x) % 60
h = (h + a) % 24
print(h, m)