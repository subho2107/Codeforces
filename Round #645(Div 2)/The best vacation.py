import bisect
n, x = map(int, input().rstrip().split())
arr = list(map(int, input().rstrip().split()))
arr = [0] + arr + arr
prefixSum1 = [0]*(2*n+1)
prefixSum2 = [0]*(2*n+1)
for pos in range(1, 2*n+1):
    prefixSum1[pos] = prefixSum1[pos-1]+arr[pos]
    prefixSum2[pos] = prefixSum2[pos-1] + (arr[pos]*(arr[pos]+1))//2
maxHugs = 0
for pos in range(2*n, n, -1):
    leftLimit = bisect.bisect_left(prefixSum1, prefixSum1[pos]-x, 1, pos)
    temp = prefixSum1[pos] - prefixSum1[leftLimit-1] - x
    sumTemp = prefixSum2[pos] - prefixSum2[leftLimit-1]
    sumTemp -= (temp*(temp+1))//2
    maxHugs = max(maxHugs, sumTemp)
print(maxHugs)

