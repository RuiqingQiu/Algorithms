from collection import defaultdict

class Solution:
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        charCount = defaultdict(int)
        for character in T:
            charCount[character] += 1
        result = ""

        for character in S:
            result += character * charCount[character]
            charCount.pop(character)

        for character in charCount:
            result += character * charCount[character]
        return result
