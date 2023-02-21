class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:

        ## T.C = O(n.k)
        ## S.C = O(k)

        buy = [float('inf')]*k
        sell = [0]*k

        for p in prices:
            for j in range(k):
                if j == 0:
                    buy[j] = min(buy[j], p)
                else:
                    buy[j] = min(buy[j], p - sell[j-1])
                
                sell[j] = max(sell[j], p - buy[j])
        
        return sell[k-1]