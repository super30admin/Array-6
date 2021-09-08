class Solution:
    # Approach 1: Brute Force
    """
    current state: 1 -> buy state; 2 -> sell state 
    
    TC: O(n)
    SC: O(n) considering the recursive stack space
    """
    def maxProfit(self, prices: List[int]) -> int:
        return self.helper(prices, 0, 1, 0, 0)
    
    def helper(self, prices, index, curr_state, max_profit, prev_buy_price):
        #base
        if index >= len(prices):
            return max_profit
        
        #logic
        
        #buy
        if curr_state == 1: # max profit earned by buying or not buying
            return max(self.helper(prices, index+1, 2, max_profit, prices[index]),\
                       self.helper(prices, index+1, 1, max_profit, prev_buy_price))
        
        #sell
        elif curr_state == 2: # max profit earned by selling or not selling
            return max(self.helper(prices, index+2, 1, max_profit + prices[index] - prev_buy_price, 0),\
                       self.helper(prices, index+1, 2, max_profit, prev_buy_price))
    
    # Approach 2: DP
    """
    TC: O(n)
    SC: O(n)
    """
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if n<2: return 0
        buy = [0] * n
        profit = [0] * n
        buy[0] = -prices[0]
        buy[1] = max(buy[0], 0 - prices[1])
        profit[1] = max(profit[0], prices[1] + buy[0])
        for i in range(2, n):
            buy[i] = max(buy[i-1], profit[i-2] - prices[i])
            profit[i] = max(profit[i-1], prices[i] + buy[i-1])
        return max(profit[-1], buy[-1])