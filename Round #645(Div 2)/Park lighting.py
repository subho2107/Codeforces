t = int(input())
for _ in range(t):
    row, col = map(int, input().rstrip().split())
    if row == col == 1:
        print(1)
        continue
    if col == 1 and row > 1:
        row, col = col, row
    if row % 2 == 0:
        print((row//2)*col)
    else:
        ans = (row-1)//2 * col
        if col % 2 == 0:
            ans += col//2
        else:
            ans += (col+1)//2
        print(ans)
