t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    diff = float("inf")
    for pos in range(n):
        for pos2 in range(pos+1, n):
            if abs(arr[pos]-arr[pos2]) < diff:
                diff = abs(arr[pos]-arr[pos2])
    print(diff)