class Solution:
    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        line_count = 0
        line_length = 0
        for letter in S:
            if line_length + widths[ord(letter) - 97] <= 100:
                line_length += widths[ord(letter) - 97]
            else:
                line_count += 1
                line_length = 0
                line_length += widths[ord(letter) - 97]
        return [line_count + 1, line_length]
            
