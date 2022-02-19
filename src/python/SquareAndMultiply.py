'''
    Square and Multiply
     - param:  (a, b, N)
        a: Base number
        b: Exponent number
        N: Number of Z group
     - return: a^b (mod N)
'''

class SAM:
    def __init__(self):
        pass

    # 1. Basic Exponentiation Algorithm
    def basicExpAlgo(self, a, b, N):
        # assume b >= 0
        ans = 1
        for i in range(b):
            ans = (ans * a) % N
        return ans

    # 2. Efficient Exponentiation Algorithm
    def effExpAlgo(self, a, b, N):
        # assume b >= 0
        x, t = a, 1
        while b > 0:
            if (b % 2) == 1:
                t = (t * x) % N
                b = b - 1
            x = (x ** 2) % N
            b = b / 2
        return t

    # 3. Another Efficient Exponentiation Algorithm
    def effExpAlgo2(self, a, b, N):
        binary = format(b, 'b')
        ans, val = 1, a

        while len(binary) > 0:
            bit = binary[len(binary)-1]

            if bit == '1': ans = (ans * val) % N
            val = (val * val) % N

            binary = binary[:-1]

        return ans



##########
## Test ##
##########
sam = SAM()

# print(sam.basicExpAlgo(3, 53, 1000000000000000000))
# print(sam.effExpAlgo(3, 53, 1000000000000000000))

# print(sam.basicExpAlgo(3, 53000000, 1000000000000000000))
# print(sam.effExpAlgo(3, 53000000, 1000000000000000000))

# print(sam.effExpAlgo2(3, 53000000, 1000000000000000000))