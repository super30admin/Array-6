class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:

        #This is an extension of Buy and Sell 3. Used an array to implement the best solution of buy and sell 3.
        buy=[float('inf') for _ in range(k+1)]
        sell=[0 for _ in range(k+1)]

        for i in range(len(prices)):
            for j in range(1,k+1):
                buy[j]=min(buy[j],prices[i]-sell[j-1])
                sell[j]=max(sell[j],prices[i]-buy[j])
        return sell[k]
