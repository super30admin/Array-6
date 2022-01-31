#Time O(n), space O(1)

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        b1=float('inf')
        p1=float('-inf')
        b2=float('inf')
        p2=float('-inf')
        
        for i in prices:
            b1=min(b1,i)
            p1=max(p1,i-b1)
            b2=min(b2,i-p1)
            p2=max(p2,i-b2)
             
        return p2
