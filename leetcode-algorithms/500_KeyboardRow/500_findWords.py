class Solution:
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        first_row = 'qwertyuiop'
        second_row = 'asdfghjkl'
        third_row = 'zxcvbnm'

        result = []
        for word in words:
            if all([character in first_row for character in word.lower()]):
                result.append(word)
            if all([character in second_row for character in word.lower()]):
                result.append(word)
            if all([character in third_row for character in word.lower()]):
                result.append(word)
        return result
