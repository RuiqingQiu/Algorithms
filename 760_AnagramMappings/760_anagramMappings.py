from collections import defaultdict

class Solution:
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        itemIndexDict = defaultdict(list)
        index = 0
        for item in B:
            itemIndexDict[item].append(index)
            index += 1
        result = []
        for item in A:
            result.append(itemIndexDict[item][0])
            itemIndexDict[item].pop(0)
        return result

        '''
        D = {x : i for i, x in enumerate(B)}
        return [D[x] for x in A]
        '''
