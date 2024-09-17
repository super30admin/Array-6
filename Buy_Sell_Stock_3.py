// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem first we try to get the min buying price and max selling price to get max profit.
when we get the profit from the first transaction is reinvested into buying the stock again and then sell the stock for high selling price.Then we end up having more profit.

# Time complexity --> o(n)
# space complexity --> o(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if prices==None or len(prices)==0:
            return 0
        #In this we have to perform two transactions to get the max profit.i.e buy the stock on a day and sell the stock on another day and again buy the stock and sell the stock.i.e do two buy and sell transactions to get the maximum profit.
        #for instance consider the input [3,3,5,0,0,3,4,5] and we have to make two buy-sell to get the max profit.
                        #lets say that buy1 is at index 3 and sell1 is at index 5.buy2 is at index 6 and sell2 is at index 7.
         #so the calculation is as follows.
         #buy1  sell1   profit1   ||||||||||  buy2                       sell2   profit2.
         #0      3      (3-0)=3           original buy price is 4.        5      (5-1)=4
         #                                but we use profit1 =3 
          #                               and pay only (4-3)=1
           #                              for the stock.
        #we do the same for each and every price.
        #The above logic is implemented below.
        buyprice1=buyprice2=float('inf')
        profit1=profit2=0
        for price in prices:
            buyprice1=min(buyprice1,price)
            profit1=max(profit1,price-buyprice1)
            
            buyprice2=min(buyprice2,price-profit1)
            profit2=max(profit2,price-buyprice2)
            print(buyprice1,profit1,buyprice2,profit2)
        return profit2