t = int(input())
result = ""
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    arr = list(map(int, input().rstrip().split()))
    if ((len(arr)==1 or len(arr)==2) and arr[0] == k) or k in arr[1:-1]:
        result += "yes\n"
    else:
        result += "no\n"
print(result)
