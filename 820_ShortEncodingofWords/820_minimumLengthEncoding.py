class Solution:
    def minimumLengthEncoding(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        # build a set of words
        s = set(words)

        # remove all suffixes of every word
        for w in words:
            for i in range(1, len(w)):
                s.discard(w[i:])

        # compute the length of the encoding string
        return sum([len(w) + 1 for w in s])
