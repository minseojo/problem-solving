def solution(n, start, temp, end) :
    if (n == 1) :
        print(start, end)

    else :
        solution(n-1, start, end, temp)
        print(start, end)
        solution(n-1, temp, start, end)

N = int(input())
print((2**N) - 1)

if(N <= 20) :
    solution(N, 1, 2, 3)
