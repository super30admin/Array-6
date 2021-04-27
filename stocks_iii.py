class Solution:
    
    """
    Description: determine maximum profit for upto two transactions from given array of stock prices
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach:
    1. define parameters for each transaction, buy and profit 
    2. start buy with either the first value in array or infinite, and starting profits shall be 0
    3. To determine maximum profit with either one or two transctions, do the following:
       - take minimum of the current price and previous first point of buy
       - take maximum of first point of buy and profit from first transaction
       - take second transaction using minimum between the current price minus profit from first transaction (effective buy price)
       - take maximum of profit from second transaction (if happens, or remains 0) and current prices minus the second price of purchase (or 0, if only limited to one transaction)
    4. At the end the second profit (account for first profit or not) will give the best value
    """
    
    def maxProfit(self, prices: List[int]) -> int:
        
        if prices == None or len(prices) < 2: return 0
        
        buy1 = prices[0]; profit1 = 0
        buy2 = prices[0]; profit2 = 0
        
        for i in range(len(prices)):
            
            buy1 = min(prices[i], buy1)
            profit1 = max(profit1, prices[i] - buy1)
            
            buy2 = min(buy2, prices[i] - profit1)
            profit2 = max(profit2, prices[i] - buy2)
            
        return profit2
