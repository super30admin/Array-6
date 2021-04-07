class Solution:
    #Solution 1
    def maxProfit(self, prices: List[int]) -> int:
        #Approach: One-pass Simulation
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the length of prices
        
        #the following are for a single transaction
        buy1, profit1 = inf, 0
        
        #the following combine both transactions
        #by reinvesting the gained profit to reduce buy2
        buy2, profit2 = inf, 0
        
        for price in prices:
            buy1 = min(buy1, price)
            profit1 = max(profit1, price - buy1)
            
            buy2 = min(buy2, price - profit1)           # effective price
            profit2 = max(profit2, price - buy2)
            
        return profit2
    
    #Solution 2
    """
    def maxProfit(self, prices: List[int]) -> int:
        #Approach: Two-pass Dynamic Proogramming
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of prices
        
        firstHalfProfits = [0 for _ in prices]
        curr_min = prices[0]
        for i in range(1, len(prices)):
            firstHalfProfits[i] = max(firstHalfProfits[i - 1], prices[i] - curr_min)
            curr_min = min(curr_min, prices[i])
        
        secondHalfProfits = [0 for _ in prices]
        curr_max = prices[-1]
        for i in reversed(range(0, len(prices) - 1)):
            secondHalfProfits[i] = max(secondHalfProfits[i + 1], curr_max - prices[i])
            curr_max = max(curr_max, prices[i])
            
        maxProfit = 0
        for i in range(len(prices)):
            maxProfit = max(maxProfit, firstHalfProfits[i] + secondHalfProfits[i])
            
        return maxProfit
    """