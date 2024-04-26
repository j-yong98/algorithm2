n = int(input())
a = list(map(int,input().split()))
a.sort()
ans = 0
cur = 0
for x in a:
    cur = cur + x
    ans += cur
print(ans)