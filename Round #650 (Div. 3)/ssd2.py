import os
import sys
from io import BytesIO, IOBase
import math
import random

def inputIntArray(): return list(map(int, input().rstrip().split()))


def inputArray(): return input().rstrip().split()


def inputVars(): return map(int, input().rstrip().split())


def inputNum(): return int(input())


sys.setrecursionlimit(100000)


def main():
    for _ in range(inputNum()):
        n, k = inputVars()
        # n = random.randrange(7, 11)
        # k = random.randrange(1, 3)
        state = input()
        # state = ''
        # temp = ['0', '1']
        # for pos in range(n):
        #     state+= temp[random.randrange(0, 2)]
        # print(n, k, state)
        if int(state) == 0:
            if len(state) <= 2 * k + 1:
                print(1)
                continue

        cnt = 0
        state = state.split('1')
        for i in range(len(state)):
            gap = state[i]
            gap = list(gap)
            # print(gap)
            if len(gap) < k+1:
                continue
            pos = k
            if i == 0:
                pos = 0
            lastSet = float('-inf')
            while pos < len(gap)-k:
                gap[pos] = '1'
                lastSet = pos
                cnt+=1
                pos += k+1
            if i == len(state)-1:
                if gap[-1] == '0' and len(gap)-1-max(-1, lastSet) > k:
                    cnt+=1
        print(cnt)
'''
1
7 1
0000100
'''
#
main()
#.........................................FAST INPUT OUTPUT.......................................
BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

#....................................END OF FAST I/O............................................

# if __name__ == "__main__":
#     main()