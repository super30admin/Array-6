class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        buy1 = float("inf")
        sell1 = 0
        buy2 = float("inf")
        sell2 = 0
        
        for i in prices:
            buy1 = min(buy1, i)
            sell1 = max(sell1, i-buy1)
            buy2 = min(buy2, i-sell1)
            sell2 = max(sell2, i-buy2)
        return sell2
        '''
        if len(prices) <= 1:
            return 0

        left_min = prices[0]
        right_max = prices[-1]

        length = len(prices)
        left_profits = [0] * length
        # pad the right DP array with an additional zero for convenience.
        right_profits = [0] * (length + 1)
        for l in range(1, length):
            left_profits[l] = max(left_profits[l-1], prices[l] - left_min)
            left_min = min(left_min, prices[l])
        
        for r in range(len(prices)-2,-1,-1):
            right_profits[r] = max(right_profits[r+1], right_max - prices[r])
            right_max = max(right_max, prices[r])
        
        max_profit = 0
        for i in range(0, length):
            max_profit = max(max_profit, left_profits[i] + right_profits[i+1])

        
        return max_profit
