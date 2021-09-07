from typing import List
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if prices == None or len(prices) == 0:
            return 0
        if k > len(prices) // 2:
            result = 0
            for i in range(1, len(prices)):
                if prices[i] > prices[i-1]:
                    result += prices[i] - prices[i-1]
            return result
        
        buy = [float(inf)] * (k+1)
        sell = [0] * (k+1)
        
        for i in range(len(prices)):
            for j in range(1, k+1):
                buy[j] = min(buy[j], prices[i] - sell[j-1])
                sell[j] = max(sell[j], prices[i] - buy[j])
        return sell[k]

# Time Complexity: O(nk)
# Space Complexity: O(k)