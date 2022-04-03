#O(n) time and O(1) space solution, n - length of prices array.
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0
        right = 1
        profit = 0
        while right < len(prices):
            if prices[left] > prices[right]:
                left = right
                
            else:
                current_profit = prices[right] - prices[left]
                profit = max(profit, current_profit)
            right += 1
        return profit

#Using minimum method.
#O(n) time and O(1) space solution, n - length of prices array
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #running minimum s30 method
        minimum = prices[0]
        maximum = 0
        for i in range(1, len(prices)):
            maximum = max(maximum, prices[i] - minimum)
            minimum = min(minimum, prices[i])
        return maximum
        