class Solution:
    def similarRGB(self, color):
        """
        :type color: str
        :rtype: str
        """
        hex_digits = '0123456789abcdef'
        red = int(color[1:3], 16)
        green = int(color[3:5], 16)
        blue = int(color[5:7], 16)
        result = '#'
        for val in [red, green, blue]:
            max_val = -10000
            max_digit = '0'
            for digit in hex_digits:
                if -(val - int(digit+digit, 16)) ** 2 > max_val:
                    max_val = -(val - int(digit+digit, 16)) ** 2
                    max_digit = digit

            result = result + (max_digit + max_digit)
        return result
