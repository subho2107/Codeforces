t = int(input())
for _ in range(t):
    a, b = map(int, input().rstrip().split())
    if 2*min(a, b) >= max(a, b):
        print((2*min(a, b))**2)
    else:
        print(max(a, b)**2)