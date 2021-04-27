class Solution:
    
    """
    Description: best time to buy and sell stocks from a given array to maximize the profit
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach:
    - Keep track of minimum number (to buy) and maximum profit at each step 
    """
    
    def maxProfit(self, prices: List[int]) -> int:
        
        if prices == None or len(prices) < 2: return 0

        profit = 0; minimum = prices[0]
        
        for i in range(1, len(prices)):
            if prices[i] - minimum > 0:
                profit = max(profit, prices[i] - minimum)
            else:
                minimum = min(minimum, prices[i])
                
        return profit
