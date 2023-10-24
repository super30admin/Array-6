class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #Method 1 - Brute force - n^4 -> consider all possible for both transactions

        #Method 2 - Improved brute force - N^3 -> 3,3,3,5,0,0,3,1,4 -> here consider the 1st transaction to be 3,3 and find 2nd transaction between 3-4 using O(n) solution in https://leetcode.com/problems/best-time-to-buy-and-sell-stock/. Then 3,3,3 is 1 transaction and the 2nd is 5-4. So on -> n^2xn-> n^3.

        #Method 3 -> reduce the n^2 part to n using helper.
        #O(n^2) - TLE
        
        # if len(prices)<2: return 0
        
        # def helper(prices,low,high):
        #     if low>high: return 0
        #     mini=prices[low]
        #     maxi=float('-inf')
        #     for i in range(low,high+1):
        #         mini=min(mini,prices[i])
        #         maxi=max(maxi,prices[i]-mini)
        #     return maxi
        
        # maximum=0
        # for i in range(len(prices)):
        #     profit1=helper(prices,0,i)
        #     profit2=helper(prices,i+1,len(prices)-1)
        #     if profit1>=0 and profit2>=0: #this if else tree is to take care of the case where single transaction is the best possible value. That is there is no need for 2nd transaction. 1,20,6,4,3 -> here buy at 1 and sell at 20 is the best possible transaction and once you do this, there is no scope to make additional profit -> single transaction is the best case. 
        #         maximum=max(maximum,profit1+profit2)
        #     elif profit1>0:
        #         maximum=max(maximum,profit1)
        #     elif profit2>0:
        #         maximum=max(maximum,profit2)
        
        # return maximum

        #Method 4 - effective transaction calulation -> this is a trick, if you know it you know it else difficult to figure out on spot.
        #TC - O(n)
        buy1=prices[0]
        sell1=0
        buy2=prices[0]
        sell2=0
        for i in range(1,len(prices)):
            buy1=min(buy1,prices[i]) #this and sell1 are trying to find best possible single transaction in the entire array-> o(n) sol from https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
            sell1=max(sell1,prices[i]-buy1)

            buy2=min(buy2,prices[i]-sell1) #buy2 tries to find effective buy price for 2 transactions hence you subtract sell1 from current price -> effective buy price for best 1st transaction -> the best 1st transaction's sell price is preserved using min. 
            sell2=max(sell2,prices[i]-buy2) #using buy2 you figure out sell2 -> effectiv sell prive for 2 transactions. 
        return sell2