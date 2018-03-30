# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        queue = []
        result = []
        queue.append(root)
        while len(queue) != 0:
            sum = 0
            count = 0
            temp = []
            while len(queue) != 0:
                current = queue.pop(0)
                if current.left != None:
                    temp.append(current.left)
                if current.right != None:
                    temp.append(current.right)
                sum += current.val
                count += 1
            queue = temp
            result.append(sum / count)
        return result
