t = int(input())
for _ in range(t):
    n = int(input())
    arr = [0]+list(map(int, input().rstrip().split()))
    dp = [1]*(n+1)
    maxAns = float("-inf")
    for i in range(1, n+1):
        for j in range(i+i,n+1,i):
            if arr[j] > arr[i]:
                dp[j] = max(dp[j], dp[i]+1)
        maxAns = max(maxAns, dp[i])
    print(maxAns)