class Solution:
    #Solution 1
    def maxProfit(self, prices: List[int]) -> int:
        #Approach: Dynamic Programming -- equivalent to Solution 2
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of prices
        
        if len(prices) < 2:
            return 0
        
        buy = [0 for _ in prices]
        buy[0] = -prices[0]
        buy[1] = max(buy[0], 0 - prices[1])
        
        sell = [0 for _ in prices]
        sell[1] = max(sell[0], prices[1] + buy[0])
        
        for i in range(2, len(prices)):
            buy[i] = max(buy[i - 1], sell[i - 2] - prices[i])
            sell[i] = max(sell[i - 1], prices[i] + buy[i - 1])
            
        return sell[-1]
    
    #Solution 2
    """
    def maxProfit(self, prices: List[int]) -> int:
        #Approach: Recursion
        #Time Complexity: O(2^n)
        #Space Complexity: O(n)
        #where, n is the length of prices
    
        self.maxProfit = 0
        self.helper(prices, 0, False, 0)
        return self.maxProfit
    
    def helper(self, prices, idx, holding, profit):
        #base
        if idx >= len(prices):
            self.maxProfit = max(self.maxProfit, profit)
            return
        
        #logic
        if not holding:
            self.helper(prices, idx + 1, False, profit)                 # not buy
            self.helper(prices, idx + 1, True, profit - prices[idx])    # buy
            
        else:   #holding
            self.helper(prices, idx + 1, True, profit)                  # not sell
            self.helper(prices, idx + 2, False, profit + prices[idx])   # sell
    """
    
    #Solution 3
    """
    def maxProfit(self, prices: List[int]) -> int:
        #Approach: Recursion
        #Time Complexity: O(2^n)
        #Space Complexity: O(n)
        #where, n is the length of prices
        
        self.maxProfit = 0
        self.helper(prices, 0, False, 0)
        return self.maxProfit
    
    def helper(self, prices, idx, holding, profit):
        #base
        self.maxProfit = max(self.maxProfit, profit)
        if idx >= len(prices):
            return
        
        #logic
        for i in range(idx, len(prices)):
            if not holding:
                self.helper(prices, i + 1, not holding, profit - prices[i])
            else:   #holding
                self.helper(prices, i + 2, not holding, profit + prices[i])
    """