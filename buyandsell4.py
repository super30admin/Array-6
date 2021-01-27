# brute force solution
# Time complexity - O(n*k) 
# Space complexity - O(k^2)
# Did this solution run on leetcode? - yes
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        
        if n==0: return 0
        
        # calculate the maximum profit 
        if k >= n//2:
            maxProfit = 0
            for i in range(1, n):
                if prices[i]>prices[i-1]:
                    maxProfit += (prices[i] - prices[i-1]) 
            return maxProfit
        
        cp = [float(inf)] * (k+1)
        profit = [0] * (k+1)
        # This is the same step as in Best Time to Buy and Sell Stock II.
        # Instead of having two variables, we create an array of size k.
        # Update all k steps for every position.
        for price in prices:
            for j in range(1, k+1):
                cp[j] = min(cp[j], price-profit[j-1])       # calculate the minimum cost price.
                profit[j] = max(profit[j], price-cp[j])     # calculate the maximum profit.
    
        return profit[k]
    