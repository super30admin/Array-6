#Time complexity : O(n)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : We iterate through the prices and keep track of the maximum profit by updating global max whenever the current 
# profit is more than previous global max. Also if the current price is lower than the global lowest price, we update that as 
# well. 
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        l=0
        maxx = 0
        for i in range(1,len(prices)):
            profit = prices[i]-prices[l]
            if profit>maxx:
                maxx=profit
            if prices[i]<prices[l]:
                l = i
        return maxx
        