class Solution:
    
    #state machine
    def maxProfit(self, prices: List[int]) -> int:
        
        s0 = [0] *len(prices)
        s1 = [0] *len(prices)
        s2 = [0] *len(prices)
        
        s0[0] = -(prices[0])
        s1[0] = 0
        s2[0] = float('-inf')
        
        for i in range(1,len(prices)):
            s1[i] = max(s1[i-1],s2[i-1])
            s0[i] = max(s0[i-1],(s1[i-1])-prices[i])
            s2[i] = s0[i-1]+prices[i]
        
        return max(s1[-1],s2[-1])
            
        
    
    
    
    #recurse
    def maxProfit_recurse(self, prices: List[int]) -> int:
        
        if not prices:
            return 0
        
        return self.dfs(prices,-1,0,0)
        
        
    def dfs(self,prices,prevbuy,index,profit):
        #base
        
        if index >=len(prices):
            return profit
        
        
        #logic
        if prevbuy == -1:
            #buy
            case1 = self.dfs(prices,prices[index],index+1,profit)
        
            #dontbuy
            case2 = self.dfs(prices,-1,index+1,profit)
            
            return max(case1,case2)
        else:
            #sell
            case3 = self.dfs(prices,-1,index+2,profit+ (prices[index] - prevbuy))
            
            #dont sell
            case4 = self.dfs(prices,prevbuy,index+1,profit)
                            
            return max(case3,case4)
