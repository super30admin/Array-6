#Time: O(n)
#space: O(1)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        b1= float('inf')
        s1=-1
        b2= float('inf')
        s2= -1

        for curr in prices:
            b1=min(curr,b1)
            s1=max(curr-b1,s1)
            b2= min(curr-s1,b2)
            s2= max(curr-b2,s2)
        return s2
        
