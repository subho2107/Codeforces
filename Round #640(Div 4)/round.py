t = int(input())
for _ in range(t):
    n = input()
    arr = []
    length = len(n)
    cnt = length-1
    for num in n:
        if int(num) != 0:
            arr.append(num+"0"*cnt)
        cnt -= 1
    print(len(arr))
    print(' '.join(arr))

