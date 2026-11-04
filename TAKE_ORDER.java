import javax.swing.JOptionPane;

public class TAKE_ORDER {
    public static void main(String[] args) {

        String toppings;
        int diameter;
        int howMany;
        String discount;
        String cardNumber;
        double amount;
        double price;
        double change;

        while (true) {

            try {

                String[] choices = {
                    "",
                    "Pepperoni",
                    "Ham and Cheese",
                    "Hawaiian"
                };

                toppings = (String) JOptionPane.showInputDialog(
                    null,
                    "Choose Toppings",
                    "Pizza Program",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]
                );

                if (toppings == null) {
                    break;
                }

                if (toppings.isEmpty()) {
                    continue;
                }

                if (toppings.equals("Pepperoni")) {
                    price = 100;
                } else if (toppings.equals("Ham and Cheese")) {
                    price = 150;
                } else {
                    price = 200;
                }

                JOptionPane.showMessageDialog(null,
                    "You chose " + toppings +
                    "\nPrice: PHP " + price);

                String input = JOptionPane.showInputDialog(
                    "Enter Diameter in inches:");

                if (input == null) {
                    continue;
                }

                diameter = Integer.parseInt(input);

                input = JOptionPane.showInputDialog(
                    "Enter How Many Orders?");

                if (input == null) {
                    continue;
                }

                howMany = Integer.parseInt(input);

                String[] discounts = {
                    "None",
                    "Senior-PWD",
                    "VIP"
                };

                discount = (String) JOptionPane.showInputDialog(
                    null,
                    "Choose Discount",
                    "Pizza Program",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    discounts,
                    discounts[0]
                );

                if (discount == null) {
                    continue;
                }

                cardNumber = JOptionPane.showInputDialog(
                    "Enter Card Number:");

                if (cardNumber == null) {
                    continue;
                }

                PIZZA pie = new PIZZA();
                pie.setToppings(toppings);
                pie.setDiameter(diameter);
                pie.setHowMany(howMany);
                pie.setDiscount(discount);
                pie.setCardNumber(cardNumber);

                double total = new BILL_ORDER().OUT(pie);

                while (true) {

                    input = JOptionPane.showInputDialog(
                        "Enter Amount:");

                    if (input == null) {
                        break;
                    }

                    amount = Double.parseDouble(input);

                    if (amount > total) {
                        change = amount - total;

                        JOptionPane.showMessageDialog(null,
                            "Your CHANGE is PHP " + change);

                        JOptionPane.showMessageDialog(null,
                            "Thank you!");

                        break;

                    } else {
                        JOptionPane.showMessageDialog(null,
                            "Insufficient Amount!");
                    }
                }

                break;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,
                    "Invalid Input! try again.");

            }
        }

        System.exit(0);
    }
}
