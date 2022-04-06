class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        Algo:
        if prev price < nect price --> sell it and add it to profit, else 
        increment prev and next by one and move on. 
        finally return the summation of all the profits.
        T = O(N)
        S = O(1)
        '''
        first, second = 0 ,1 
        profit , max_profit = 0 , 0 
        while second < len(prices) and first < second:
            # print("first, second , profit", first, second , profit  )
            if prices[first] < prices[second]:
                # print("first, second , profit", first, second , profit  )
                profit += prices[second] - prices[first]
                # first += 1
                # second += 1
            first += 1
            second += 1
            # max_profit = max(max_profit , profit )
        return profit
    
