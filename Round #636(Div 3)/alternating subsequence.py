t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    sumOfSubs = 0
    maxVal = arr[0]
    sign = '-'
    if arr[0] > 0:
        sign = '+'
    for num in arr[1:]:
        if num < 0 and sign == '-':
            if num > maxVal:
                maxVal = num
        elif num > 0 and sign == '+':
            if num > maxVal:
                maxVal = num
        else:
            if sign == '-':
                sumOfSubs += maxVal
                sign = '+'
                maxVal = num
            else:
                sumOfSubs += maxVal
                sign = '-'
                maxVal = num

    sumOfSubs += maxVal

    print(sumOfSubs)


