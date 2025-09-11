from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        re = float("-inf")
        minVal = float("inf")
        for price in prices:
            minVal = min(minVal, price)
            re = max(re, price-minVal)
        return re

        