class Solution:
    
    """
    Description: find maximum profit for up to k transactions for a list of stock prices
    
    Time Complexity: O(nk)
    Space Complexity: O(k)
    
    Approach:
    1. on similar lines for 2 transaction problems, create a buy and profit array with maximum values in buy and 0 in profit array
    2. Using the same principle, fill in values by updating effective buy rate at every index
       - take minimum of current buy value and current prices minus earlier profit (effective buy price)
       - maximize the profit by taking maximum of current value in profit array and current price minus effective buy price
    3. the last value in profit array is the result
    """
    
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if prices == None or len(prices) < 2: return 0

        buy_array = [float("inf") for i in range(k + 1)] 
        profit_array = [0 for i in range(k + 1)]
        
        for i in range(len(prices)):
            for j in range(1, k + 1):
                
                buy_array[j] = min(buy_array[j], prices[i] - profit_array[j - 1])
                profit_array[j] = max(profit_array[j], prices[i] - buy_array[j])
        
        return profit_array[k]
