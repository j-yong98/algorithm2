def dfs(i,l):
    if l > n:
        return
    for j in range(n):
        if arr[i][j] == 1:
            if l < ans[j]:
                ans[j] = l
                dfs(j,l+1)
n,m = map(int,input().split())
arr = [[0] * n for _ in range(n)]
min_num = 10**6
idx = -1
for _ in range(m):
    a, b = map(int,input().split())
    arr[a-1][b-1] = 1
    arr[b-1][a-1] = 1
for i in range(n):
    ans = [10**6 for _ in range(n)]
    ans[i] = 0
    dfs(i,1)
    if min_num > sum(ans):
        min_num = sum(ans)
        idx = i
print(idx+1)