class Solution:
    def shortestToChar(self, S, C):
        """
        :type S: str
        :type C: str
        :rtype: List[int]
        """
        distance_lst = [len(S)] * len(S)

        character_pos = []

        for index, character in enumerate(S):
            if character == C:
                character_pos.append(index)
            
        for index, character in enumerate(S):
            if character == C:
                distance_lst[index] = 0
            else:
                distance_lst[index] = min([abs(index - pos)for pos in character_pos])
        return distance_lst
