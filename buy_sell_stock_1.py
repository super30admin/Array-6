class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        Algo : 
        keep track of the min price so far 
        starting from the first element in the prices array 
        calculate the profit and max profit for each iteration from the second element till the end   
        T = O(N)
        S = O(1)
        '''
        min_ = prices[0]
        profit = 0 
        max_profit = 0
        for i in range(1, len(prices)):
            profit = prices[i] - min_
            min_ = min(min_ , prices[i] )
            max_profit = max(max_profit , profit)
        return max_profit
    
    def BruteForcemaxProfit(self, prices: List[int]) -> int:
        '''
        iterate over the array and treate each element as the buying element 
        if the prev element is < next element 
        and 
        iterate over the rest of the array to calculate the profit and hence max profit 
        if prev element > next element then increment both the values and move to next iteration
        T = O(n^2)
        S = O(1)
        '''
        first, second = 0 , 1 
        max_profit = 0 
        profit = 0 
        while first < second and second < len(prices) :
            # print("out", first , second )
            profit = 0 
            while second < len(prices) and prices[first] < prices[second] :
                # print("in", first , second )
                profit = prices[second] - prices[first]
                # print("profit", profit )
                max_profit = max(max_profit , profit )
                second += 1
            first += 1
            second = first + 1
            
        return max_profit
    
    
    
    
