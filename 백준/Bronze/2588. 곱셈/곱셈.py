x1 = int(input())
x2 = int(input())
tmp = x2
while (tmp > 0):
    d = tmp % 10
    tmp //= 10
    print(x1 * d)
print(x1 * x2)