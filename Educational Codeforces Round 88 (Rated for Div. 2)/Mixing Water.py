from fractions import Fraction as frac
t = int(input())
for _ in range(t):
    hotTemp, coldTemp, barrelTemp = map(int, input().rstrip().split())
    if barrelTemp == hotTemp:
        print(1)
    elif (hotTemp+coldTemp) >= barrelTemp*2:
        print(2)
    else:
        cups1 = (barrelTemp - coldTemp) // ((2 * barrelTemp) - (hotTemp + coldTemp))
        cups2 = cups1+1
        finalTemp1 = frac((hotTemp * cups1) + (coldTemp * (cups1 - 1)), (2 * cups1 - 1))
        finalTemp2 = frac((hotTemp*cups2) + (coldTemp*(cups2-1)),(2*cups2 - 1))
        if abs(barrelTemp - finalTemp1) <= abs(barrelTemp - finalTemp2):
            cups1 = 2*cups1 - 1
            print(cups1)
        else:
            cups2 = 2*cups2 - 1
            print(cups2)




