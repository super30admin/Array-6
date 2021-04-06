class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        #Approach: One-pass Simulation  //  refer LeetCode #123 for explanation
        #Time Complexity: O(n * k)
        #Space Complexity: O(k)
        #where, n is the length of prices
        
        if not prices or k == 0:
            return 0
        
        buyK = [inf for _ in range(k)]
        profitK = [0 for _ in range(k)]
        
        for price in prices:
            buyK[0] = min(buyK[0], price)
            profitK[0] = max(profitK[0], price - buyK[0])
            
            for i in range(1, k):
                buyK[i] = min(buyK[i], price - profitK[i - 1])
                profitK[i] = max(profitK[i], price - buyK[i])
                
        return profitK[-1]