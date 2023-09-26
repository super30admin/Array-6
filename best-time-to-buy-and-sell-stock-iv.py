class Solution:
    
    def f(self, i, buy, k, prices):
        
        if k==0 or i==len(prices):
            return 0
        if self.dp[(i, buy, k)] != -1:
            return self.dp[(i, buy, k)]
        
        if buy:
            take = -prices[i] + self.f(i+1, 0, k, prices)
            not_take = self.f(i+1, 1, k, prices)
            self.dp[(i, buy, k)] = max(take, not_take)
        else:
            sell = prices[i] + self.f(i+1, 1, k-1, prices)
            not_sell = self.f(i+1, 0, k, prices)
            self.dp[(i, buy, k)] = max(sell, not_sell)
        return self.dp[(i, buy, k)]
    
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        self.dp = defaultdict(lambda: -1)
        return self.f(0, 1, k, prices)