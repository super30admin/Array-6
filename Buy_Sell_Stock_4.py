 // Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we try to maximise our profit by minimising the buying price and maximising the selling price.
we do this for all the values in the input array.
 
 # Time complexity --> o(len(prices))
# space complexity --> o(k)
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if prices==None or len(prices)==0 or k==0:
            return 0
        sum1=0
        #This case is when there are more transactions than the length of the input, which means we are doing more transactions than the given prices which is not possible, then we again limit our calculation only to the length of the prices.
        #As now there are unlimited transactions instead of searching for min buying price and max selling price we take all the values which has increasing price.
        if k>len(prices):
            for i in range(len(prices)-1):
                if prices[i+1]-prices[i]>0:
                    sum1=sum1+(prices[i+1]-prices[i])
            return sum1
        #in this problem we perform k transations to get the max profit.The logic is similar to the buy and sell stocks 3 problem# except here we do for k transactions.
        #consider the example 
        #input =[3 , 2 ,   6   ,  5 ,   6 ,  10 ,   14 ,  20 ]
        #           buy1  sell1       buy2   sell2  buy3  sell3
        # consider the above three transactions happend.
        # buy1     sell1   profit1   buy2        sell2   profit2     buy3        sell3   profit3
        #  2         6       (6-2)=  original=6  (10)   (10-2)      orig=14     20      (20-6)=14
        #                      4     current=             =8       curr=14-8               
        #                           (6-4(profit1))                    =6
        #                                =2
         #Total profit =14 for 3 transactions,we do the same way for k transactions.
         
        buyprices=[float('inf') for i in range(k)]
        profit=[0 for i in range(k)]
        for price in prices:
            buyprices[0]=min(buyprices[0],price)
            profit[0]=max(profit[0],price-buyprices[0])
            for j in range(1,k):
                buyprices[j]=min(buyprices[j],price-profit[j-1])
                profit[j]=max(profit[j],price-buyprices[j])
        return profit[len(profit)-1]
        