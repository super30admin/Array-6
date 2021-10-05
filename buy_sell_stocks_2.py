#Time Complexity: O(N) #N is #of elements in array

#Space Complexity: O(1) 
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        total =0
        
        for index,item in enumerate(prices):
            
            if index == 0: continue
            if item > prices[index-1]:
                total+=item-prices[index-1]
            
        return total
        
        