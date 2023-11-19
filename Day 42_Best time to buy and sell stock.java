class Solution {
    public int maxProfit(int[] prices) {
        //creating variables
        int min=prices[0] ;
        int max=0;
        int profit=0;
        //if their is no element in array or no prices
        if(prices.length==0){
            return 0;
        }
        else{
            for(int stockprice: prices){
                min=Math.min(stockprice,min); 
                profit=stockprice-min;
                max=Math.max(profit,max);
            }
        }
        return max;
    }
}