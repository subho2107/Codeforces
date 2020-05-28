t = int(input())
for _ in range(t):
    n = int(input())
    if n < 4:
        print(-1)
        continue
    dup = n
    if n&1==0:
        n-=1
    while n >= 1:
        print(n, end = " ")
        n -= 2
    print("4 2", end=" ")
    num = 6

    if dup&1!=0:
        dup-=1
    while num <= dup:
        print(num, end=" ")
        num += 2
    print(" ")