class Solution:
    def rotatedDigits(self, N):
        count = 0
        for num in range(1, N + 1):
            number = str(num)
            if '3' in number or '7' in number or '4' in number:
                continue
            if '2' in number or '5' in number or '6' in number or '9' in number:
                count += 1
        return count
