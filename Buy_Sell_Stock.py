// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
As per the question both buying and selling the stocks are done one after the another.
As we have to maximise the profit we have to get the lowest cost price possible and more selling price for the same object.

# Time complexity --> o(n)
# space complexity --> o(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if prices==None or len(prices)==0:
            return 0
        #we are to find the max profit that he can get by buying and selling the stock and one can be done only after the other.
        #we know profit=sellingprice-costprice.
        #so if cost price is as min as possible and sellingprice is as high as possible we are to get the maximum possible profit.
        buyprice=float('inf')
        profit=0
        for price in prices:
            buyprice=min(buyprice,price)
            profit=max(profit,price-buyprice)
        return profit