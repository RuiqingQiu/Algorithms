class Solution:
    def validTicTacToe(self, board):
        """
        :type board: List[str]
        :rtype: bool
        """

        # count the number of X and O
        numOfX = 0
        numOfO = 0
        for row in board:
            for character in row:
                if character == 'X':
                    numOfX += 1
                elif character == 'O':
                    numOfO += 1
        if (numOfX - numOfO < 0):
            return False
        elif (numOfX - numOfO > 1):
            return False
        result = ''
         # rows and columns
        for i in range(0, 3):
            if board[0][i] != ' ' and board[0][i] == board[1][i] == board[2][i]:
                if (result != ''):
                    return False
                result = board[0][i]

            if board[i][0] != ' ' and board[i][0] == board[i][1] == board[i][2]:
                if (result != ''):
                    return False
                result = board[i][0]

        # diagonal
        if board[0][0] != ' ' and (board[0][0] == board[1][1] == board[2][2]):
            if (result != ''):
                return False
            result = board[0][0]

        if board[0][2] != ' ' and (board[0][2] == board[1][1] == board[2][0]):
            if (result != ''):
                return False
            result = board[0][2]


        if (result == 'X'):
            if (numOfX - numOfO == 0):
                return False

        if (result == 'O'):
            if (numOfX != numOfO):
                return False
        return True
