import random

t = int(input())
for _ in range(t):
    n = int(input())
    # n = random.randrange(2, 20,2)
    mid = n//2
    arr = []
    num = 2
    sumOfEven = 0
    for pos in range(mid):
        arr.append(num)
        sumOfEven += num
        num += 2
    def calSumOdd(a, sumOfOdd):
        if sumOfOdd == sumOfEven:
            if len(arr) != n:
                return "NO"
            return "YES"
        if a >= sumOfEven:
            return "NO"
        if a + sumOfOdd > sumOfEven:
            pop1 = arr.pop()
            sumOfOdd -= pop1
            yesOrNo = calSumOdd(a, sumOfOdd)
            return yesOrNo
        arr.append(a)
        sumOfOdd += a
        a += 2
        yesOrNo = calSumOdd(a, sumOfOdd)
        return yesOrNo
    yesOrNo = calSumOdd(1, 0)
    print(yesOrNo)
    if yesOrNo == "YES":
        for num in arr:
            print(num, end=" ")
        print("")


