class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        #Method 1 - Recrusion, explore everything at every position -> We have 2 states -> buy and sell. And in each state 2 options -> buy/sell and no buy/no sell -> O(2^n) TC.
        # def helper(prices,idx,state,profit):
        #     #base
        #     if idx>=len(prices): return profit

        #     #logic
        #     #if in buy state
        #     if not state:
        #         #we have buy and no buy, so return the max between them.
        #         return max(helper(prices,idx+1,True,profit-prices[idx]),helper(prices,idx+1,False,profit)) 
                    #Above - buy and not buy respectively
        #     else:
        #         #we have sell and no sell, so return max between them.
        #         return max(helper(prices,idx+2,False,profit+prices[idx]),helper(prices,idx+1,True,profit))
                     #Above - sell and not sell respectively
        # return helper(prices,0,False,0)

        #Method 2 -> in above case there are repeating sub problem. ->5,2,1,2,7,0,5,2,3,6. If you are at 1 and sell the stock -> you have finished 5,2,1 and looking for profit from 7-6 and if you are at 7 and haven't bought it yet then trying to look for profit from 7-6. -> Repeating sub problems -> DP

        #DP - O(n) TC
        n=len(prices)
        if n<2: return 0
        dpBuy=[0 for _ in range(n)]
        dpSell=[0 for _ in range(n)]
        dpBuy[0]=-prices[0]
        dpBuy[1]=max(dpBuy[0],0-prices[1])
        dpSell[1]=max(0,dpBuy[0]+prices[1])
        for i in range(2,n):
            dpBuy[i]=max(dpBuy[i-1],dpSell[i-2]-prices[i]) #max between no buy and to buy, in buy similar to above, profit-prices[idx] here we do previous sell-prices[i] -> effective profit and return the max
            dpSell[i]=max(dpSell[i-1],prices[i]+dpBuy[i-1]) #max between no sell and to sell, in sell, similar to above,profit+prices[idx] here we do previous buy+proces[i]
            #here both dpBuy and dpSell keep track of effective profit so far, hence we'll use the eachother when buying and selling.

        return max(dpBuy[n-1],dpSell[n-1])

