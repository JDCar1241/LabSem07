package strategy;

public class FixedAmountDiscountStrategy implements DiscountStrategy {
        private double fixedAmount;

        public FixedAmountDiscountStrategy (double fixedAmount){
            this.fixedAmount = fixedAmount;
        }
        @Override
        public double applyDiscount(double total){
            double finalTotal = Math.max(0,total)
        }
}
