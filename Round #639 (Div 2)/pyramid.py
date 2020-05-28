t = int(input())

for _ in range(t):
    n = int(input())
    pyramids = 0
    while n>1:
        h = 1
        cards = 0
        while True:
            temp =  int((1/2)*h*(3*h + 1))
            if temp <= n:
                cards = temp
            else:
                break
            h += 1
        n -= cards
        pyramids+=1
    print(pyramids)
