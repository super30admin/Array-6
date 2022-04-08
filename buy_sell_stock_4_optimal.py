class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        '''
        T = 0(N)
        S = O(1)
        '''
        if not prices or k == 0 : return 0 
        buy = [ sys.maxsize ]*k
        sell = [0]*k
        for i in range(len(prices)):
            for j in range(k):
                if j == 0:
                    buy[j] = min(buy[j] , prices[i])
                else: 	
                    buy[j] = min(buy[j] , prices[i] - sell[j-1])
                sell[j] = max(sell[j] , prices[i] - buy[j])
        return sell[k-1]
    
