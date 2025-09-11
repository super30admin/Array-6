from typing import List
# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         def maxProfitFromTransaction(l,r):
#             re = float("-inf")
#             minVal = float("inf")
#             for i in range(l,r+1):
#                 price = prices[i]
#                 minVal = min(minVal, price)
#                 re = max(re, price-minVal)
#             return re
#         newre = float("-inf")
#         single = maxProfitFromTransaction(0,len(prices)-1)
#         newre = max(newre,single)
#         for i in range(0,len(prices)-1):
#             for j in range(i+1,len(prices)):
#                 curr = maxProfitFromTransaction(i,j) + maxProfitFromTransaction(j+1,len(prices)-1)
#                 newre = max(newre,curr)
#         return newre

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1,buy2,sell1,sell2= float("inf"), float("inf"), float("-inf"), float("-inf")
        for i in range(len(prices)):
            buy1 = min(buy1,prices[i])
            sell1 = max(sell1, prices[i]-buy1)
            buy2 = min(buy2, prices[i]-sell1)
            sell2 = max(sell2,prices[i]-buy2)
        return sell2
        
        

        