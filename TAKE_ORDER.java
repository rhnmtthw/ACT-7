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
        double total;

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
                    "\nwhich costs additional " + (int) price + "php");

                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure?\nYou want " + toppings + "?",
                        "Confirm Question",
                        JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                    continue;
                }

                String input;

                while (true) {

                    input = JOptionPane.showInputDialog(
                        "Enter Diameter in inches:");

                    if (input != null) {
                        break;
                    }

                    cancelOrder();
                }

                diameter = Integer.parseInt(input);

                while (true) {

                    input = JOptionPane.showInputDialog(
                        "Enter How Many?");

                    if (input != null) {
                        break;
                    }

                    cancelOrder();
                }

                howMany = Integer.parseInt(input);

                String[] discounts = {
                    "N/A",
                    "Senior-PWD",
                    "VIP"
                };

                int choice;

                while (true) {

                    choice = JOptionPane.showOptionDialog(
                        null,
                        "Choose Discount:",
                        "Pizza Program",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        discounts,
                        null
                    );

                    if (choice != JOptionPane.CLOSED_OPTION) {
                        break;
                    }

                    cancelOrder();
                }

                discount = discounts[choice];

                cardNumber = "N/A";

                if (!discount.equals("N/A")) {

                    while (true) {

                        cardNumber = JOptionPane.showInputDialog(
                            "Enter " + discount + " Card Number:");

                        if (cardNumber != null) {
                            break;
                        }

                        cancelOrder();
                    }
                }

                PIZZA pie = new PIZZA();
                pie.setToppings(toppings);
                pie.setDiameter(diameter);
                pie.setHowMany(howMany);
                pie.setDiscount(discount);
                pie.setCardNumber(cardNumber);

                total = new BILL_ORDER().OUT(pie);

                while (true) {

                    input = JOptionPane.showInputDialog(
                        "Enter Amount:");

                    if (input == null) {

                        cancelOrder();

                        continue;
                    }

                    amount = Double.parseDouble(input);

                    if (amount > total) {
                        change = amount - total;

                        JOptionPane.showMessageDialog(null,
                            "Your CHANGE is Php" + String.format("%.2f", change));

                        JOptionPane.showMessageDialog(null,
                            "Thank you!");

                        break;

                    } else {
                        JOptionPane.showMessageDialog(null,
                            "Insufficient Amount");
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

    private static void cancelOrder() {

        if (JOptionPane.showConfirmDialog(null,
                "Want to CANCEL the order?",
                "Confirm Question",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null,
                "Thank you!");

            System.exit(0);
        }
    }
}
