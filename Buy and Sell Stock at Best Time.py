#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # n = len(prices)
        # maxprofit = 0
        # for i in range(0, n):
        #     for j in range(i+1,n):
        #         if(prices[j]>prices[i]):
        #             profit = prices[j]-prices[i]
        #             maxprofit = max(maxprofit,profit)
        # return maxprofit

        l = 0
        r = 1
        n = len(prices)
        maxprofit = 0
        while(r<n):
            if(prices[r]>prices[l]):
                profit = prices[r]-prices[l]
                maxprofit = max(maxprofit,profit)
            else:
                l=r
            r+=1
        return maxprofit

        