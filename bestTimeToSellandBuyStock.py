class Solution:
    # TC : O(n)
    # SC : O(1)
    def maxProfit(self, prices: List[int]) -> int:
        if prices is None:
            return 0
        minprice,maxprice = float('inf'),0
        for i in range(len(prices)):
            minprice = min(minprice,prices[i])
            maxprice = max(maxprice,prices[i]-minprice)
        return maxprice