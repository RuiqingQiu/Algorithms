class Solution:
    def selfDividingNumbers(self, left, right):
        def checkIfSelfDividing (num):
            num_copy = int(num)
            while num_copy > 0 :
                digit = num_copy % 10
                if digit == 0:
                    return False
                if num % digit != 0:
                    return False
                num_copy = int(num_copy / 10)
            return True
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        result =  []
        for num in range(left, right + 1):
            if checkIfSelfDividing(num):
                result.append(num)
        return result
