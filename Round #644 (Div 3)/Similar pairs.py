import collections
# def help(num, arr):
t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    evenCount = 0
    oddCount = 0
    for num in arr:
        if num&1:
            oddCount+=1
        else:
            evenCount+=1
    if oddCount%2 == evenCount%2 == 0:
        print("YES")
        continue
    check = False
    arr.sort()
    for pos in range(n-1):
        if arr[pos+1]-arr[pos]==1:
            check = True
            break
    if check and oddCount&1 and evenCount&1:
        print("YES")
    else:
        print("NO")