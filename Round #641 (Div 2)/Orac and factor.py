m = 1000000
leastPrimefactor = [0]*(m+1)
leastPrimefactor[1] = 1
for i in range(2, m+1):
    if leastPrimefactor[i] == 0:
        leastPrimefactor[i] = i
        for j in range(i,m+1,i):
            if leastPrimefactor[j] == 0:
                leastPrimefactor[j] = i
t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    div = leastPrimefactor[n]
    n += div
    if k == 1:
        print(n)
        continue
    n += 2 * (k - 1)
    print(n)
