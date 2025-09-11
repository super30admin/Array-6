from typing import List
# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         n = len(prices)
#         memo = [[None] *2 for _ in range(n)]
#         def helper(prices,idx,flag):
#             # base
#             if idx>=len(prices): return 0
#             # logic
#             if flag:
#                 # no buy
#                 case1 = helper(prices, idx+1, flag)
#                 # buy
#                 case2 = helper(prices,idx+1, False) - prices[idx]
#                 return max(case1,case2)
#             else:
#                 # no sell
#                 case3 = helper(prices,idx+1,False)
#                 # sell
#                 case4 = prices[idx]+helper(prices,idx+2, True)
#                 return max(case3,case4)
            
#         return helper(prices,0,True)

# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         n = len(prices)
#         memo = [[None] *2 for _ in range(n)]
#         def helper(prices,idx,flag):
#             # base
#             if idx>=len(prices): return 0
#             # logic
#             if flag:
#                 if memo[idx][0]: return memo[idx][0]
#                 # no buy
#                 case1 = helper(prices, idx+1, flag)
#                 # buy
#                 case2 = helper(prices,idx+1, False) - prices[idx]
#                 memo[idx][0] = max(case1,case2)
#                 return memo[idx][0]
#             else:
#                 if memo[idx][1]: return memo[idx][1]
#                 # no sell
#                 case3 = helper(prices,idx+1,False)
#                 # sell
#                 case4 = prices[idx]+helper(prices,idx+2, True)
#                 memo[idx][1] = max(case3,case4)
#                 return memo[idx][1]
            
#         return helper(prices,0,True)

# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         n = len(prices)
#         memo = [[-1] *2 for _ in range(n)]
#         def helper(prices,idx,flag):
#             # base
#             if idx>=len(prices): return 0
#             # logic
#             if flag:
#                 if memo[idx][0]!=-1: return memo[idx][0]
#                 # no buy
#                 case1 = helper(prices, idx+1, flag)
#                 # buy
#                 case2 = helper(prices,idx+1, False) - prices[idx]
#                 memo[idx][0] = max(case1,case2)
#                 return memo[idx][0]
#             else:
#                 if memo[idx][1]!=-1: return memo[idx][1]
#                 # no sell
#                 case3 = helper(prices,idx+1,False)
#                 # sell
#                 case4 = prices[idx]+helper(prices,idx+2, True)
#                 memo[idx][1] = max(case3,case4)
#                 return memo[idx][1]
            
#         return helper(prices,0,True)

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if n == 1: return 0
        dp = [[0,0] for _ in range(n)]
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        dp[1][0] = max(-prices[0], -prices[1])
        dp[1][1] = max(dp[0][1] ,prices[1]+dp[0][0])
        for i in range(2,n):
            dp[i][0] = max(dp[i-1][0], dp[i-2][1]-prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])
        return dp[n-1][1]