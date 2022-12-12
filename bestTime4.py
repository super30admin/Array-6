#Time: O(n * k)
#Space: O(n * k)
#Program ran on leetcode successfully

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        profit = [[1] * (n+1)] * (k+1)

        for i in range(k):
            profit[i][0] = 0
            
        for i in range(n):
            profit[0][i] = 0
        
        for i in range(1, k):
            prev_max = float('-inf')
            for j in range(1, n):
                prev_max = max(prev_max, profit[i-1][j-1] - prices[j-1])
                profit[i][j] = max(profit[i][j-1], prices[j] + prev_max)
        
        return profit[k][n-1]