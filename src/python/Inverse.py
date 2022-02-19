'''
    Inverse
     - param:  (a, N)
        a: Number to find inverse
        N: Number of Z group
     - return: inverse a
'''

class Inverse:
    def __init__(self):
        self.inv = 0

    # 1. Euclidean Algorithm
    def gcd(self, a, b):
        if a < b:
            a, b = b, a

        if b == 0:
            return a
        # if a % b == 0:
        #     return b
        else:
            return self.gcd(b, a%b)

    # 2. Extended Euclidean Algorithm
    def eea(self, a, b):
        if a < b:
            a, b = b, a
        
        r0, r1 = a, b
        s0, s1 = 1, 0
        t0, t1 = 0, 1

        while r1 > 0:
            q = r0 // r1
            r = r0 - q*r1
            r0, r1 = r1, r

            s = s0 - q*s1
            s0, s1 = s1, s

            t = t0 - q*t1
            t0, t1 = t1, t
        
        self.inv = t0
        return "gcd({}, {}) = ({})*{} + ({})*{} = {}".format(a, b, s0, a, t0, b, r0)

    # 3. Inverse
    def inverse(self, N, a):
        if N < a:
            return "N must be greater than a"
        
        if self.gcd(N,a) == 1:
            self.eea(N, a)
            # if self.inv < 0:
            #     return "{} (or {})".format(N+self.inv, self.inv)
            # else:
            #     return "{} (or {})".format(self.inv, self.inv-N)
            return self.inv
        else:
            return "{} doesn't have inverse in Z {} Group".format(a, N)




##########
## Test ##
##########
inv = Inverse()

# print(inv.gcd(18, 12))
# print(inv.gcd(53, 17))

# print(inv.eea(18, 12))
# print(inv.eea(120, 44))

# print(inv.inverse(12, 18))
# print(inv.inverse(18, 12))
# print(inv.inverse(53, 17))
# print(inv.inverse(100, 23))