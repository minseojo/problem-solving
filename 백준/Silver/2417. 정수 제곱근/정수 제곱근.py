n = int(input())

l = 0
r= 2**63

while(l <= r) :
    m = (l+r) // 2
    if(m**2 < n) :
        l = m + 1
    else :
        r = m - 1

print(r+1)