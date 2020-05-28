t = int(input())
for _ in range(t):
    n, k = map(int , input().rstrip().split())
    n1 = n - (k-1)
    if n1 % 2 != 0 and n1 > 0:
        print("YES")
        for pos in range(k-1):print("1", end = " ")
        print(n1)
        continue
    n2 = n - 2*(k-1)
    if n2 % 2 == 0 and n2 > 0:
        print("YES")
        for pos in range(k-1):print("2", end = " ")
        print(n2)
        continue
    print("NO")