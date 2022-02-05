# Array-6

## Problem1: Buy and Sell Stock at Best Time (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mini=float('inf')
        profit=0
        for i in range(len(prices)):
            if prices[i]<mini:
                mini=prices[i]
            elif prices[i]-mini>profit:
                profit=prices[i]-mini
        return profit
                
        


## Problem2: Buy and Sell Stock at Best Time III (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1=float('inf')
        profit1=0
        buy2=float('inf')
        profit2=0
        for i in range(len(prices)):
            buy1=min(buy1,prices[i])
            profit1=max(profit1,prices[i]-buy1)
            buy2=min(buy2,prices[i]-profit1)
            profit2=max(profit2,prices[i]-buy2)
        return profit2
        
        
        

## Problem3: Buy and Sell Stock at Best Time IV (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        buy=[float('inf') for _ in range(k)]
        if k<=0:
            return 0
        profit=[0 for _ in range(k)]
        for i in range(len(prices)):
            for j in range(k):
                if j==0:
                    buy[j]=min(buy[j],prices[i])
                
                else:
                    buy[j]=min(buy[j],prices[i]-profit[j-1])
                profit[j]=max(profit[j],prices[i]-buy[j])
        return profit[k-1]
        
        

## Problem4: Buy and Sell Stock with cooldown https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        L = len(prices)
        MP = [0] * (L + 2)

        for i in range(L-1, -1, -1):
            C1 = 0
            for sell in range(i + 1, L):
                profit = (prices[sell] - prices[i]) + MP[sell + 2]
                C1 = max(profit, C1)
            C2 = MP[i + 1]
            MP[i] = max(C1, C2)

        return MP[0]