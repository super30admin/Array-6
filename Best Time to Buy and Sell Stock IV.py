'''
Time Complexity: O(n*k)
Space Complexity: O(k)
Did this code successfully run on Leetcode : Yes
Explanation: If k = 2
For each day check if the price is less than the buy1, if its true then make buy1 the price by finding
min(buy1, price). If the price - buy1 > profit1 so far then update profit1  = price - buy1. (done using min instead of
if condition).
Next computer the second buy2 which is min(buy2, price - previous Profit which we got ie profit1) and the final profit
is max(profit2, price - buy2).
return profit2

Instead of creating the 2 variables we create 2 arrays buy[k] for buy1 and buy2 and profit[k] for profit1 and profit2
and for every price compute the k values and save in the array, in the next price we can use the computed values in the
array to generate the buy and profit values
'''


class Solution:
    def solve(self, prices):
        maxProfit = 0

        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                maxProfit += prices[i] - prices[i - 1]

        return maxProfit

    def maxProfit(self, K: int, prices: List[int]) -> int:

        if K >= len(prices) / 2:
            return self.solve(prices)

        buy = [math.inf for i in range(K + 1)]
        profit = [0 for i in range(K + 1)]

        for price in prices:
            for k in range(1, K + 1):
                buy[k] = min(buy[k], price - profit[k - 1])
                profit[k] = max(profit[k], price - buy[k])

        return profit[-1]