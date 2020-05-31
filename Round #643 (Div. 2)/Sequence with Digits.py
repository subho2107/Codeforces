t = int(input())
for _ in range(t):
    firstNum, k = map(int, input().rstrip().split())
    ans = 0
    for pos in range(k-1):
        minDig = int(min(list(str(firstNum))))
        if minDig == 0:
            break
        maxDig = int(max(list(str(firstNum))))
        firstNum += minDig*maxDig
    print(firstNum)