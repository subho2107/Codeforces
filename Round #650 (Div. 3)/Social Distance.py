import os
import sys
from io import BytesIO, IOBase
import math


def inputIntArray(): return list(map(int, input().rstrip().split()))


def inputArray(): return input().rstrip().split()


def inputVars(): return map(int, input().rstrip().split())


def inputNum(): return int(input())


sys.setrecursionlimit(100000)


def main():
    for _ in range(inputNum()):
        n, k = inputVars()
        state = input()
        if int(state) == 0:
            if len(state) <= 2*k+1:
                print(1)
            else:
                print(n//(k+1))
            continue
        cnt = 0
        first1 = 0
        for pos in range(n):
            if state[pos] == '1':
                first1 = pos
                break
        cnt += first1//(k+1)
        pos = first1+k+1
        while pos < n:
            if state[pos] == '0':
                if pos+k+1 > n:
                    cnt+=1
                    break
                else:
                    prev = pos
                    while pos < n and state[pos] != '1':
                        pos +=1
                    if pos-prev > k:
                        cnt+=1
                    pos += k+1
            else:
                pos+=1
        print(cnt)
# main()
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

if __name__ == "__main__":
    main()