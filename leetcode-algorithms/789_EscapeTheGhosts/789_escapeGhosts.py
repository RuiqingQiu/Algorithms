class Solution:
    def escapeGhosts(self, ghosts, target):
        def stepToTarget(ghost, target):
            return abs(ghost[0] - target[0]) + abs(ghost[1] - target[1])
        """
        :type ghosts: List[List[int]]
        :type target: List[int]
        :rtype: bool
        """
        escape_steps = abs(target[0]) + abs(target[1])

        for ghost in ghosts:
            if (stepToTarget(ghost, target) <= escape_steps) :
                return False
        return True
        
