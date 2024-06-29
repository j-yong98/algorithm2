n = int(input())
arr = list(map(int,input().split()))
cnt = 0
for x in arr:
    r = x % 10
    if (n == r):
        cnt += 1
print(cnt)