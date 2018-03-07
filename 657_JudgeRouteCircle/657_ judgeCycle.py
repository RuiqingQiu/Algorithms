class Solution:
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        horizontalMove = 0
        verticalMove = 0
        for move in moves:
            if move == 'U':
                verticalMove += 1
            elif move == 'D':
                verticalMove -= 1
            elif move == 'L':
                horizontalMove -= 1
            elif move == 'R':
                horizontalMove += 1
        return horizontalMove == 0 and verticalMove == 0
