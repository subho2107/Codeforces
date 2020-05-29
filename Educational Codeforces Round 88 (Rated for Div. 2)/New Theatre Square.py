t = int(input())
for _ in range(t):
    n, m, x, y = map(int, input().rstrip().split())
    priceForDouble = min(2*x, y)
    arr = []
    cost = 0
    for row in range(n):
        rowArr = list(input())
        if len(rowArr) == 1 and rowArr[0] == '.':
            cost += x
        for col in range(1, m):
            if col+1 < m and rowArr[col] == '.' and rowArr[col-1] == '*' and rowArr[col+1] == '.':
                continue
            if rowArr[col] == '.' and rowArr[col-1] == '.':
                cost += priceForDouble
            elif rowArr[col] == '.' or rowArr[col-1] == '.':
                cost += x
            rowArr[col], rowArr[col-1] = '*', '*'
    print(cost)

