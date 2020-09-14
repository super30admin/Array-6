# Time Complexity : O(n*k) [n = len of prices list]
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def maxProfitUnlimitedTransactions(self, prices):
        if not prices:return 0
        i = 0
        j = 0
        n = len(prices)
        res = 0
        while i < n-1 and j < n:
            while i < n-1 and prices[i] > prices[i+1]:
                i+=1
            valley = prices[i]
            j = i+1
            while j < n-1 and prices[j] < prices[j+1]: 
                j+=1
            if j == n:
                 return res
            peak = prices[j]
            i=j+1
            res+= (peak-valley)
        return res
        
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        # any number of transactions can be performed
        if k > (len(prices)//2):
            return self.maxProfitUnlimitedTransactions(prices)
        
        buy = [float('inf') for _ in range(k+1)]
        sell = [0 for _ in range(k+1)]
        
        for price in prices:
            for i in range(1, k+1):
                buy[i] = min(buy[i], price - sell[i-1])
                sell[i] = max(sell[i], price - buy[i])
                
        return sell[k]