from collections import defaultdict

class Solution:
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        ban = set(banned)
        split_result = [str.strip("!?;',.") for str in paragraph.lower().split(' ')]

        word_count = defaultdict(int)
        for word in split_result:
            if word not in ban:
                word_count[word] += 1
        return max(word_count, key=lambda k: word_count[k])
