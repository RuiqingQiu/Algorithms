class Solution:
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # greater_map = {}
        # for index in range(len(nums2)):
        #     i = index + 1
        #     found = False
        #     while i < len(nums2):
        #         if (nums2[i] > nums2[index]):
        #             greater_map[nums2[index]] = nums2[i]
        #             found = True
        #             break
        #         i += 1
        #     if not found:
        #         greater_map[nums2[index]] = -1
        #
        # result = []
        # for num in nums1:
        #     result.append(greater_map[num])
        # return result

        greater_map = {}
        stack = []
        result = []

        for num in nums2:
            while len(stack) != 0 and stack[-1] < num:
                greater_map[stack.pop()] = num
            stack.append(num)

        return [greater_map.get(num, -1) for num in nums1]
