class Solution:
    def expressiveWords(self, S, words):
        """
        :type S: str
        :type words: List[str]
        :rtype: int
        """
        tmp = []
        i = 0
        while i < len(S):
            if i + 2 < len(S) and S[i:i+3] == S[i]*3:
                index = len(S)
                for j in range(i + 3, len(S)):
                    if S[j] != S[j-1]:
                        index = j
                        break
                tmp.append((str(index-i), S[i]))
                i = index
            else:
                tmp.append(('', S[i]))
                i += 1

        result = 0
        for word in words:
            i, j = 0, 0
            while i < len(tmp) and j < len(word):
                if tmp[i][0].isdigit():
                    count = int(l[i][0])
                    if tmp[i][1] != word[j]:
                        break
                    # find occurence in word
                    while j < len(word) and word[j] == tmp[i][1]:
                        j, count = j + 1, count - 1
                    # no enough occurence in string S
                    if count < 0:
                        break
                    i += 1
                else:
                    if tmp[i][1] != word[j]:
                        break
                    i, j = i + 1, j + 1

            if i == len(l) and j == len(word):
                result += 1

        return result
