class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # T: O(n), S: O(1)
        hold1 = hold2 = float("-inf")
        sell1 = sell2 = 0

        for price in prices:
            sell2 = max(sell2, hold2 + price)
            hold2 = max(hold2, sell1 - price)
            sell1 = max(sell1, hold1 + price)
            hold1 = max(hold1, -price)

        return sell2
