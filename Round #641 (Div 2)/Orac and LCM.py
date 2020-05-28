def gcd(num1, num2):
    while num1:
        num2, num1 = num1, num2 % num1
    return num2
n = int(input())
arr = list(map(int, input().rstrip().split()))
gcdPreComp = [0]*(n-1) + [arr[-1]]
for pos in range(len(arr)-2, -1, -1):
    gcdPreComp[pos] = gcd(arr[pos],gcdPreComp[pos+1])
res = 0
for pos in range(n-1):
    temp = (arr[pos]*(gcdPreComp[pos+1]))//gcdPreComp[pos]
    res = gcd(res, temp)
print(res)
