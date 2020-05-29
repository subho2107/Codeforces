n = int(input())
arr = list(map(int, input().rstrip().split()))
ans = 0
for maxNum in range(30, 0, -1):
    maxSum = 0

    for pos in range(len(arr)):
        if arr[pos] > maxNum:
            maxSum = 0
            continue
        maxSum+=arr[pos]
        maxSum = max(maxSum, 0)
        ans = max(ans, maxSum-maxNum)
print(ans)