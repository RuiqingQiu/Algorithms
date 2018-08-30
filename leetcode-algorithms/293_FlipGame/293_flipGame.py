class Solution:
    def generatePossibleNextMoves(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        # previous_is_plus = False
        # result = []
        # for index, letter in enumerate(s):
        #     if letter == '+':
        #         if previous_is_plus:
        #             tmp = list(s)
        #             tmp[index-1] = '-'
        #             tmp[index] = '-'
        #             result.append(''.join(tmp)
        #         else:
        #             previous_is_plus = True
        #     else:
        #         previous_is_plus = False
        # return result
        return [s[:index] + '--' + s[index+2:]  for index in range(len(s) - 1) if s[index] == s[index + 1] == '+']

            
