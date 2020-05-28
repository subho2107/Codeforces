
t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    diff = (k-1)//(n-1)
    print(diff+k)
