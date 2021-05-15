package DesignPattern.strategy;

public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }
    public void execute(){
        promotionStrategy.doPromotion();
    }

    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//        String promotionKey = "COUPON";
//        if(promotionKey.equals("COUPON")){
//            promotionActivity = new PromotionActivity(new CouponStrategy());
//        }else if(promotionKey.equals("CASHBACK")){
//            promotionActivity = new PromotionActivity(new CashbackStrategy());
//        }
//        promotionActivity.execute();
        //单例工厂模式完善以后
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }
}
