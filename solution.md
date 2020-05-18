# Problem 1: Best Time to Buy and Sell Stock
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def maxProfit(self, prices: List[int]) -> int:
              res=0
              for i in range(len(prices)):
                  if len(prices)>1:
                      if i==0:
                          continue
                      else:
                          temp=prices[i]-min(prices[:i])
                          if temp>res:
                              res=temp
                  else:
                      break
              return res

# Problem 2: Best Time to Buy and Sell Stock III
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def maxProfit(self, prices: List[int]) -> int:
              one_buy = two_buy =   sys.maxsize
              one_profit = two_profit = 0
              for p in prices:
                  one_buy = min(one_buy,p)
                  one_profit = max(one_profit,p - one_buy)
                  two_buy = min(two_buy,p - one_profit)
                  two_profit = max(two_profit,p - two_buy)
              return two_profit

# Problem 3: Best Time to Buy and Sell Stock IV
## Time Complexity :
O(len(prices))

## Space Complexity :
O(k)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def maxProfit(self, k: int, prices: List[int]) -> int:
              if not prices or len(prices)==0 or k==0:
                  return 0
              sum1=0
              if k>len(prices):
                  for i in range(len(prices)-1):
                      if prices[i+1]-prices[i]>0:
                          sum1=sum1+(prices[i+1]-prices[i])
                  return sum1

              buyprices=[sys.maxsize]*k
              profit=[0]*k
              for price in prices:
                  buyprices[0]=min(buyprices[0],price)
                  profit[0]=max(profit[0],price-buyprices[0])
                  for j in range(1,k):
                      buyprices[j]=min(buyprices[j],price-profit[j-1])
                      profit[j]=max(profit[j],price-buyprices[j])
              return profit[len(profit)-1]
