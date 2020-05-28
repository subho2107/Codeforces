t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    arr = list(map(int, input().rstrip().split()))
    peaks = {}
    for pos in range(1, n-1):
        if arr[pos] > arr[pos-1] and arr[pos] > arr[pos+1]:
            peaks[pos] = 1
    lmax = n-k+1#1 indexed
    minL = 0
    maxPeaks = 0
    dpPeaks = [0]*n
    # print(peaks)
    for pos in range(1, n):
        if pos in peaks:
            dpPeaks[pos] = dpPeaks[pos-1]+1
        else:
            dpPeaks[pos] += dpPeaks[pos-1]
    # print(dpPeaks)
    for l in range(lmax):
        r = l+k-1
        #l+1 to l+k-3
        if r-l <= 1:
            continue
        noOfPeaks = dpPeaks[r-1] - dpPeaks[l]
        if noOfPeaks > maxPeaks:
            maxPeaks = noOfPeaks
            minL = l
    print(maxPeaks+1, minL+1)
