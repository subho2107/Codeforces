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
    sumOfOdd = 0
    a= 1
    yesOrNo = ""

    for pos in range(mid - 1):
        arr.append(a)
        sumOfOdd += a
        a += 2
    # print(sumOfEven, sumOfOdd, sumOfEven-sumOfOdd)
    if (sumOfEven - sumOfOdd) % 2 == 0 or sumOfOdd == 0:
        print("NO")
    else:
        print("YES")
        arr.append(sumOfEven-sumOfOdd)
        for num in arr:
            print(num, end=" ")
        print("")



