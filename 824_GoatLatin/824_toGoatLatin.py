class Solution:
    def toGoatLatin(self, S):
        """
        :type S: str
        :rtype: str
        """
        vowel = ['a', 'e', 'i', 'o', 'u']
        result = ''
        index = 1
        for word in S.split():
            if word[0].lower() in vowel:
                result += word + "ma" + "a" * index + " "
            else:
                result += word[1:] + word[0] + "ma" + "a" * index + " "
            index += 1
        return result[:-1]
