t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    if k == 0:
        print(sum(a))
        continue
    res = 0
    a.sort()
    b.sort(reverse=True)
    for pos in range(n):
        if pos < k:
            res += max(a[pos], b[pos])
        else:
            res+=a[pos]
    print(res)