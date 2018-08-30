class Solution:
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        tmp = s.split(' ')
        for index, word in enumerate(tmp):
            tmp[index] = word[::-1]
        return ' '.join(tmp)
        
