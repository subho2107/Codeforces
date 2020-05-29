import math
t = int(input())
for _ in range(t):
    totalNoOfCards, noOfJokers, noOfPeople  = map(int, input().rstrip().split())
    if noOfJokers <= totalNoOfCards//noOfPeople or noOfJokers == 0:
        print(noOfJokers)
    else:
        score = totalNoOfCards//noOfPeople
        secondHigh = math.ceil((noOfJokers-score)/(noOfPeople-1))
        score -= secondHigh
        print(score)