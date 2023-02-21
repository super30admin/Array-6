class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        ## T.C = O(n)
        ## S.C = O(1)
        
        min_price = prices[0]
        mx_profit = 0

        for p in prices:
            min_price = min(min_price, p)
            mx_profit = max(mx_profit, p - min_price)
        
        return mx_profit
        