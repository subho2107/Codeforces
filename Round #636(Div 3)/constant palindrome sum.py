t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    arr = list(map(int, input().rstrip().split()))
    pairsNeeding0chng = {}
    pairsNeeding01chng = [0]*(2*k+2)
    for pos in range(n//2):
        L = min(arr[pos], arr[n-pos-1])
        R = max(arr[pos], arr[n-pos-1])
        if L+R in pairsNeeding0chng:
            pairsNeeding0chng[L+R] += 1
        else:
            pairsNeeding0chng[L+R] = 1
        pairsNeeding01chng[L+1] += 1
        pairsNeeding01chng[R+k+1] -= 1
    for pos in range(2, len(pairsNeeding01chng)):
        pairsNeeding01chng[pos] += pairsNeeding01chng[pos-1]
    pairsNeeding01chng.pop()

    minChngs = -1
    for x in range(2, 2*k +1):
        noOf0pair = 0
        if x in pairsNeeding0chng:
            noOf0pair += pairsNeeding0chng[x]
        noOf1pair = pairsNeeding01chng[x] - noOf0pair
        noOf2pair = (n//2) - noOf0pair - noOf1pair
        totChngs = noOf1pair + (noOf2pair*2)
        if totChngs < minChngs or minChngs == -1:
            minChngs = totChngs

    print(minChngs)
