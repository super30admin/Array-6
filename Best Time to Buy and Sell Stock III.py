'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: For each day check if the price is less than the buy1, if its true then make buy1 the price by finding
min(buy1, price). If the price - buy1 > profit1 so far then update profit1  = price - buy1. (done using min instead of
if condition).
Next computer the second buy2 which is min(buy2, price - previous Profit which we got ie profit1) and the final profit
is max(profit2, price - buy2).
return profit2
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy1 = math.inf
        buy2 = math.inf
        profit1 = 0
        profit2 = 0
        for price in prices:
            buy1 = min(buy1, price)
            profit1 = max(profit1, price - buy1)
            buy2 = min(buy2, price - profit1)
            profit2 = max(profit2, price - buy2)

        return profit2