#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        left_max = [0] * n
        right_max = [0] * n
        min_price = prices[0]
        for i in range(n):
            min_price = min(min_price, prices[i])
            left_max[i] = max(left_max[i-1], prices[i] - min_price)
        
        max_price = prices[-1]
        for i in reversed(range(n-1)):
            max_price = max(max_price, prices[i])
            right_max[i] = max(right_max[i+1], max_price - prices[i])
        
        res = 0
        for i in range(n):
            res = max(res, right_max[i] + left_max[i])
        
        return res