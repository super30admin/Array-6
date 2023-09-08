"""
Problem : 4

Time Complexity : 

Approach 1 - O(2^n)
Approach 2&3 - O(n)

Space Complexity :

Approach 1 - O(2^n)
Approach 2 - O(n)
Approach 3 - O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Buy and Sell Stock with cooldown

# Approach - 1
# Recursive

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        if not prices or len(prices)<2:
            return 0
        
        return self.helper(prices,0,-1,0)
    
    def helper(self,prices,idx,prevBuy,profit):
        # base
        if idx>=len(prices):
            return profit

        # buy state or sell state
        if prevBuy==-1:
            # buy
            case1=self.helper(prices,idx+1,prices[idx],profit)
            # don't buy
            case2=self.helper(prices,idx+1,prevBuy,profit)
            return max(case1,case2)

        else:
            # sell
            case1=self.helper(prices,idx+2,-1,profit+prices[idx]-prevBuy)
            # don't sell
            case2=self.helper(prices,idx+1,prevBuy,profit)
            return max(case1,case2)
        

# Approach - 2
# DP Array

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n=len(prices)
        dpBuy=[0 for _ in range(n)]
        dpBuy[0]=-prices[0]
        dpSell=[0 for _ in range(n)]
        for i in range(1,n):
            if i==1:   
                dpBuy[i]=max(dpBuy[i-1],0-prices[i])
            else:
                dpBuy[i]=max(dpBuy[i-1],dpSell[i-2]-prices[i])
            dpSell[i]=max(dpSell[i-1],prices[i]+dpBuy[i-1])
        return max(dpBuy[n-1],dpSell[n-1])
    
# Approach - 3
# DP - Constant Space

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices or len(prices)<2:
            return 0
        n=len(prices)
        prevBuy=-prices[0]
        currBuy=max(prevBuy,0-prices[1])
        prevSell=0
        currSell=max(prevSell,prices[1]+prevBuy)
        for i in range(2,n):
            tempBuy=currBuy
            currBuy=max(currBuy,prevSell-prices[i])
            tempSell=currSell
            currSell=max(currSell,prices[i]+tempBuy)
            prevBuy=tempBuy
            prevSell=tempSell
        return max(currSell,currBuy)