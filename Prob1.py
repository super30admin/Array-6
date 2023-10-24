class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #Method 1 - Brute force, check all possible 2 pointers -> O(n^2)

        #Method 2 - improved brute force - buy at minimum so far.
        # if len(prices)<2: return 0
        # mini=prices[0]
        # maxi=float('-inf')
        # buyidx=sellidx=currbuyidx=0
        # for i in range(1,len(prices)):
        #     if mini>prices[i]:  #keep track of min so far
        #         mini=prices[i]
        #         currbuyidx=i
        #     if maxi<prices[i]-mini: #use this minimum to get max profit by checking with each price.
        #         maxi=prices[i]-mini
        #         buyidx=currbuyidx #print it without this update, youll understand
        #         sellidx=i
        # print(buyidx,sellidx)
        # return maxi

        #condensed version of method 2
        if len(prices)<2: return 0
        mini=prices[0]
        maxi=float('-inf')
        for i in range(1,len(prices)):
            mini=min(mini,prices[i])
            maxi=max(maxi,prices[i]-mini)
        return maxi



        