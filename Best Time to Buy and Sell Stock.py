class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #Approach: Linear traversal
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the length of prices
        
        curr_min = prices[0]
        max_profit = 0
        for price in prices:
            max_profit = max(max_profit, price - curr_min)
            curr_min = min(curr_min, price)
        
        return max_profit