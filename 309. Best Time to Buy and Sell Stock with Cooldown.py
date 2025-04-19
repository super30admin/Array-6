#space:O(n)
#time:O(n)
#approach- using dp to calculate 
#buy price as max of previous buy and sell price of i-2(cooldown) - current buy price
#sell price as max of previous sell and current buy price+ previous buy price
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n=len(prices)
        if n==1:
            return 0
        buy=[0]*n
        sell=[0]*n
        buy[0]= -prices[0]
        buy[1]= max(buy[0], sell[0]-prices[1])
        sell[1]=max(sell[0], prices[1]+buy[0])
        for i in range(2,n):
            buy[i]=max(buy[i-1], sell[i-2]-prices[i])
            sell[i]=max(sell[i-1], prices[i]+buy[i-1])
        return sell[n-1]
