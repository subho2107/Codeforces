t = int(input())
for _ in range(t):
    n = int(input())
    hisAnswer = list(map(int, input().rstrip().split()))
    myAnswer = []
    minUnoccupied = 1
    check = False
    if n % 2 == 0 :
        if hisAnswer[0] == n and hisAnswer[-1] == 1 and hisAnswer[1:-2] == sorted(hisAnswer[1:-2]):
            check = True
    else:
        if hisAnswer[-1] == 1 and hisAnswer[0:-2] == sorted(hisAnswer[0:-2]):
            check = True
    if check:
        print("Yes")
    else:
        print("No")



