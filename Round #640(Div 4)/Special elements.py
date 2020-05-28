
t = int(input())
for _ in range(t):
    input()
    arr = list(map(int, input().rstrip().split()))
    hashSum = {}
    for num in arr:
        if num not in hashSum:
            hashSum[num] = 1
        else:
            hashSum[num] += 1
    cnt = 0
    for pos in range(len(arr)):
        s = arr[pos]
        for pos2 in range(pos+1, len(arr)):
            s += arr[pos2]
            if s in hashSum:
                cnt += hashSum[s]
                del hashSum[s]
    print(cnt)
