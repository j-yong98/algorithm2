cnt = [1, 1, 2, 2, 2, 8]
inp = list(map(int, input().split()))
for i in range(len(cnt)):
    print(cnt[i] - inp[i],end=' ')