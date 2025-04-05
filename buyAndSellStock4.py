class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        # T: O(n * k), S: O(k)
        if not prices:
            return 0

        n = len(prices)
        if k >= n // 2:
            # If k is large enough, the problem is equivalent to unlimited transactions.
            return sum(max(prices[i + 1] - prices[i], 0) for i in range(n - 1))

        hold = [-float("inf")] * (k + 1)
        sell = [0] * (k + 1)

        for price in prices:
            for i in range(1, k + 1):
                hold[i] = max(hold[i], sell[i - 1] - price)
                sell[i] = max(sell[i], hold[i] + price)

        return sell[k]
