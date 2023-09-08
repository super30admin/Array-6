"""
Problem : 1

Time Complexity : O()
Space Complexity : O()

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Buy and Sell Stock at Best Time

# Approach - 1

class Solution(object):
    def maxProfit(self, prices):
        l,r=0,1
        maxpr=0

        while r<len(prices):
           
            if prices[l]<prices[r]:
                profit=prices[r]-prices[l]
                maxpr=max(profit,maxpr)
            else:
                l=r
            r+=1
        return maxpr


# Approach - 2

class Solution(object):
    def maxProfit(self, prices):
        if not prices:
            return 0
        minn=prices[0]
        maxx=0
        buyIdx,currBuyIdx,sellIdx=0,0,0
        for i in range(len(prices)):
            if minn>prices[i]:
                minn=prices[i]
                currBuyIdx=i
            if maxx<prices[i]-minn:
                maxx=prices[i]-minn
                buyIdx=currBuyIdx
                sellIdx=i
        print(buyIdx,sellIdx)
        return maxx