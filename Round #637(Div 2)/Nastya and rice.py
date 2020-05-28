t = int(input())
for _ in range(t):
    n, a, b, c, d = map(int, input().rstrip().split())
    if (n*(a-b) >= c-d and n*(a-b) <= c+d) or (n*(a+b) >= c-d and n*(a+b) <= c+d) or(n*(a-b)<= c-d and n*(a+b)>=c+d):
        print("Yes")
    else:
        print("No")
