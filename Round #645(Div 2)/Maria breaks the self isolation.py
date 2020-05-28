t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    arr.sort()
    pos = 0
    prev = 1
    # ans = 0
    while pos < len(arr):
        cnt = 0
        starting = pos-1
        while True and pos < len(arr):
            if (arr[pos]<=(pos-starting)-1+prev):
                cnt += 1
            elif cnt > 0:
                break
            pos += 1
        if cnt == 0:
            break
        # ans += starting-pos
        prev += pos-1-starting
    print(prev)
