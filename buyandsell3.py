# Bi-directional dynamic programming solution (Leetcode solution)
# Consider dividing the array into two halves at every position
# Find the maximum profit by adding left and right subarray.
# profit = left[i]+right[i+1]
# Time complexity - O(2n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        
        # length of prices array
        n = len(prices)
        
        left = [0]*n
        right = [0]*(n+1)
        
        leftmin = float('inf')
        rightmax = float('-inf')
        for i in range(1, n):
            # update the left minimum (buying price)
            leftmin = min(leftmin, prices[i-1])
            
            # update the right maximum (selling price)
            rightmax = max(rightmax, prices[n-i])
            
            # Find the maximum left profit 
            left[i] = max(left[i-1], prices[i] - leftmin)

            # Find the maximum right profit
            right[n-i-1] = max(right[n-i], rightmax - prices[n-i-1])
        
        # calculate the maximum profit
        for i in range(n):
            profit = max(profit, left[i]+right[i+1])     
        return profit
    

# Time complexity - O(n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cp1, cp2 = float('inf'), float('inf')
        profit1 = profit2 = 0
        
        for price in prices:
            # update the cost price in the first transaction.
            cp1 = min(cp1, price)
            
            # calculate the profit in the first transaction.
            profit1 = max(profit1, price-cp1)
            
            # update the cost price 2 to include profit 1.
            cp2 = min(cp2, price-profit1)
            
            # calculate the profit in the second transaction.
            profit2 = max(profit2, price-cp2)
            
        return profit2   