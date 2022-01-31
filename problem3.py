#Time O(n*k), space O(k)
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not k:
            return 0
        
        b=[float('inf')]*k
        p=[0]*k
        
        for i in range(len(prices)):
            for j in range(k):
                
                if j==0:
                    b[j]=min(b[j],prices[i])
                else:
                    b[j]=min(b[j],prices[i]-p[j-1])
                    
                p[j]=max(p[j],prices[i]-b[j])
        print(b)
        print(p)       
        return p[k-1]
