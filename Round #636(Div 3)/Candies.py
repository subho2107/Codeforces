t = int(input())
for _ in range(t):
    n = int(input())
    sumOfSeries = 3
    a = 4
    while sumOfSeries != n:
        if n % sumOfSeries == 0:
            break
        sumOfSeries += a
        a*=2
    print(n//sumOfSeries)
