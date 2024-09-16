#Time complexity : O(n)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : We treat buy and sell like 2 states, if we buy the money is reduced and if we sell the money increases. Now to get
# any profit, we need sell amount greater than buy amount. Since here we can do 2 transactions at most, we have total of 4 states.
# And here we treat these 2 transactions as one to reach to final state (or the final profit)
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        k=2
        states = [0] + [-float('inf') for i in range(2*k)]
        states[1] = -prices[0]
        
        for i in range(1,len(prices)):
            for j in range(k):
                states[2*j+1] = max(states[2*j+1],states[2*j]-prices[i]  ) #buy, subtract from prev state
                states[2*j+2] = max(states[2*j+2], states[2*j+1]+prices[i] ) #sell. add to prev state
                
        return max(0,states[-1])