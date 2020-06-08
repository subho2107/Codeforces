import os
import sys
from io import BytesIO, IOBase
import math
import bisect

def inputIntArray():
    return list(map(int, input().rstrip().split()))


def inputArray():
    return input().rstrip().split()


def inputVars():
    return map(int, input().rstrip().split())


def inputNum():
    return int(input())

def solve(arr1, arr2, arr3):
    res = float('inf')
    for num in arr1:
        pos2 = bisect.bisect_left(arr2, num)
        pos3 = bisect.bisect_right(arr3, num)
        if pos2 == len(arr2) or pos3 == 0:
            continue
        num2 = arr2[pos2]
        num3 = arr3[pos3-1]
        res = min(res, ((num-num2)**2)+((num-num3)**2)+((num2-num3)**2))
    return res


def main():
    for _ in range(inputNum()):
        r, g, b = inputVars()
        arrR, arrG, arrB = sorted(inputIntArray()), sorted(inputIntArray()), sorted(inputIntArray())
        res = min(solve(arrR, arrG, arrB), solve(arrR,arrB, arrG),
                  solve(arrB, arrR, arrG), solve(arrB, arrG, arrR),
                  solve(arrG, arrR, arrB), solve(arrG, arrB, arrR))
        print(res)





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