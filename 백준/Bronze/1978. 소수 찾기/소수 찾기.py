n = int(input())
arr = map(int, input().split())
ans = 0
for x in arr:
    flag = 1
    for j in range(2, int(x ** 0.5) + 1):
        if x % j == 0:
            flag = 0
            break
    if x != 1 and flag == 1:
        ans += 1
        
print(ans)