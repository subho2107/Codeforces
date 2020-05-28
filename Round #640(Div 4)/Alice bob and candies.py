t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().rstrip().split()))
    bobPrev = 0
    alicePrev = 0
    bobTotal = 0
    aliceTotal = 0
    moves = 0
    while len(arr)!=0:
        candiesConsume = 0
        if moves % 2 == 0:
            while candiesConsume <= bobPrev and len(arr)!=0:
                candiesConsume += arr[0]
                arr.pop(0)
            aliceTotal += candiesConsume
            alicePrev = candiesConsume
        else:
            while candiesConsume <= alicePrev and len(arr)!=0:
                candiesConsume += arr[-1]
                arr.pop()
            bobTotal += candiesConsume
            bobPrev = candiesConsume
        moves += 1
    print(moves, aliceTotal, bobTotal)
