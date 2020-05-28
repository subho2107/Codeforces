t = int(input())
for _ in range(t):
    n = int(input())
    n = (n-1)//2
    res = n*(n+1)*(2*n+1)
    res = 8*(res//6)
    print(res)
