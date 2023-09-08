"""
Problem : 2

Time Complexity : 
Approach 1 - O(n^2)
Approach 2 - O(n)

Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Buy and Sell Stock at Best Time III

# Approach - 1

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        maxx=0
        n=len(prices)
        for i in range(n):
            first=self.helper(prices,0,i)
            second=self.helper(prices,i+1,n-1)
            maxx=max(maxx,first+second)

        return maxx

    def helper(self,prices,l,r):
        if l>r:
            return 0
        minn,maxx=prices[l],0
        for i in range(l,r+1):
            minn=min(minn,prices[i])
            maxx=max(maxx,prices[i]-minn)
        return maxx


# Approach - 2

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        
        buy1=prices[0]
        # sell1=max(0,prices[0]-buy1)
        sell1=0
        buy2=prices[0]
        # sell2=max(0,prices[0]-buy2)
        sell2=0

        for i in range(len(prices)):
            buy1=min(buy1,prices[i])
            sell1=max(sell1,prices[i]-buy1)
            buy2=min(buy2,prices[i]-sell1)
            sell2=max(sell2,prices[i]-buy2)
        return sell2
    
# Approach - 3

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        return self.helper(prices,0,-1,0,0)

    def helper(self,prices,idx,prevBuy,profit,transactions):
        # base
        if transactions==2:
            return profit
        if idx==len(prices):
            return profit
        # logic
        if prevBuy==-1:
            return max(self.helper(prices,idx+1,-1,profit,transactions),self.helper(prices,idx+1,prices[idx],profit,transactions))
        else:
            return max(self.helper(prices,idx+1,-1,profit+prices[idx]-prevBuy,transactions+1),self.helper(prices,idx+1,prevBuy,profit,transactions))
        
# Approach - 4

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        return self.helper(prices,0,False,0,0)

    def helper(self,prices,idx,bought,profit,transactions):
        # base
        if transactions==2:
            return profit
        if idx==len(prices):
            return profit
        # logic
        if not bought:
            return max(self.helper(prices,idx+1,False,profit,transactions),self.helper(prices,idx+1,True,profit-prices[idx],transactions))
        else:
            return max(self.helper(prices,idx+1,False,profit+prices[idx],transactions+1),self.helper(prices,idx+1,True,profit,transactions))