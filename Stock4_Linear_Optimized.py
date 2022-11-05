# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # check for null case and len of prices less than 2
        if not prices or len(prices) < 2:
            return 0
        
        # Update the variables as prevBuy, prevSell and prevprevSell
        n = len(prices)
        prevBuy = max(-prices[0], -prices[1])
        prevprevSell = 0
        prevSell = max(prevprevSell, prevBuy + prices[1])
        
        # traverse over the length of prices
        for i in range(2,n):
            # update the variables according to the logic and finding the max profit
            temp = prevSell
            prevSell = max(prevSell, prevBuy + prices[i])
            prevBuy = max(prevBuy, prevprevSell - prices[i])
            
            # update the prevprevSell with prevSell at the end
            prevprevSell = temp
        
        # return the final profit which is stored in prevSel
        return prevSell
