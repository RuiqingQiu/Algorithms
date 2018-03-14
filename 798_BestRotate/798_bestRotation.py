# Time limit exceed brute force
# class Solution:
#     def bestRotation(self, A):
#         """
#         :type A: List[int]
#         :rtype: int
#         """
#         result = [0] * len(A)
#         maxScore = -1
#         maxIndex = -1
#         for k in range(0, len(A)):
#             score = 0
#             for i in range(0, len(A)):
#                 if (len(A) + (i-k)) % len(A) >= A[i]:
#                     score += 1
#             result[k] = score
#             if score > maxScore:
#                 maxScore = score
#                 maxIndex = k
#         return maxIndex

# Provided solution
# class Solution:
#     def bestRotation(self, A):
#         N = len(A)
#         bad = [0] * N
#         for i, x in enumerate(A):
#             left, right = (i - x + 1) % N, (i + 1) % N
#             bad[left] -= 1
#             bad[right] += 1
#             if left > right:
#                 bad[0] -= 1
#
#         best = -N
#         ans = cur = 0
#         for i, score in enumerate(bad):
#             cur += score
#             if cur > best:
#                 best = cur
#                 ans = i
# 
#         return ans

# 5 lines in python
class Solution:
    def bestRotation(self, A):
        N = len(A)
        change = [1] * N
        for i in range(N):
            change[(i - A[i] + 1) % N] -= 1
        print(change)
        for i in range(1, N):
            change[i] += change[i - 1]

        return change.index(max(change))
