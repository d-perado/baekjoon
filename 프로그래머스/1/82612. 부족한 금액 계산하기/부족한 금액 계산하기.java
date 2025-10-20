class Solution {
    public long solution(int price, int money, int count) {
        
        long needMoney = 0;
        for(int i=1;i<=count;i++){
            needMoney=needMoney+(price*i);
            System.out.println(needMoney);
        }
        
        if(needMoney>money){
            return needMoney-money;
        }
        
        return 0;
    }
}