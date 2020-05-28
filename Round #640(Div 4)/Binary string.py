t = int(input())
for _ in range(t):
    n0, n1, n2 = map(int, input().rstrip().split())
    if n1==0:
        if n0 != 0:
            print('0' * (n0 + 1))
        else:
            print('1' * (n2 + 1))
    else:
        res = ''
        for pos in range(n1+1):
            if pos&1:
                res += '0'
            else:
                res +='1'
        pos1 = res.index('1')
        res = res[0:pos1]+'1'*n2 + res[pos1:]
        pos0 = res.index('0')
        res = res[0:pos0]+('0'*n0)+res[pos0:]
        print(res)