class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        T = O(N)
        S = O(1)
        '''
        first, second = 0 , 1 
        buy, sell = 0 ,0 
        profit = 0 
        while second < len(prices):
            if prices[first] <  prices[second]:
                buy = prices[first]
                second += 1
            if prices[first] > prices[second]:
                sell = prices[first]
                profit = sell - buy
                first += 1
                second += 1
        return profit
        
