t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().rstrip().split())
    print((c-a)*(d-b)+1)