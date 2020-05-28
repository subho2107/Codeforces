t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    hashRem = {rem:0 for rem in range(0, n)}
    check = True
    for pos in range(len(arr)):
        newRoom = (pos+arr[pos])%n
        if hashRem[newRoom] == 1:
            check = False
            break
        hashRem[newRoom] += 1
    if check:
        print("YES")
    else:
        print("NO")
