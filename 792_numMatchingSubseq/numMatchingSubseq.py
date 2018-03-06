class Solution:
    def numMatchingSubseq(self, S, words):
        """
        :type S: str
        :type words: List[str]
        :rtype: int
        """
        indexOfChar = {}
        for i in range(len(S)):
            if S[i] not in indexOfChar:
                indexOfChar[S[i]] = [i]
            else:
                indexOfChar[S[i]].append(i)
        count = 0
        for word in words:
            left_pointer = -1
            for i in range(len(word)):
                success = False
                if (word[i] not in indexOfChar):
                    break
                for index in indexOfChar[word[i]]:
                    if left_pointer < index:
                        left_pointer = index
                        success = True
                        break
                if (not success):
                    break
                elif (i == len(word) - 1):
                    count += 1
        return count
