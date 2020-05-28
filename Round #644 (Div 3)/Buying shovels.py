import math

t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    if k == 1:
        print(n)
        continue
    if n <= k:
        print(1)
        continue
    fact = 1
    factorArray = []
    while fact <= int(math.sqrt(n)):
        if n % fact == 0:
            factorArray.append(fact)
            if n//fact != fact:
                factorArray.append(n//fact)
        fact+=1
    ans = 0
    factorArray.sort()
    for num in factorArray:
        if num <= k:
            ans = num
        else:
            break
    # print(n//ans)
    ans = n//ans
    print(ans)