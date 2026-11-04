import javax.swing.JOptionPane;

public class BILL_ORDER {

    public double OUT(PIZZA PIE) {

        PIE.computePrice();

        JOptionPane.showMessageDialog(
            null,
            "You ordered for " + PIE.getToppings() +
            " Pizza\n" +

            "with the size of " +
            String.format("%.2f", PIE.getDiameter() * 2.54) +
            " centimeter\n" + "\n" +

            "Number of Orders: " + PIE.getHowMany() + "\n" +

            "Discount: " + PIE.getDiscount() + "\n" +

            "Card Number: " + PIE.getCardNumber() + "\n\n" +

            "Amount Due: PHP " +
            String.format("%.2f", PIE.getPrice()),

            "BILL ORDER",
            JOptionPane.INFORMATION_MESSAGE
        );

        return PIE.getPrice();

    }

}