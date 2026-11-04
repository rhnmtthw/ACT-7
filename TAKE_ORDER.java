import javax.swing.JOptionPane;

public class TAKE_ORDER {
    public static void main(String[] args) {

        String toppings;
        double price = 0;
        double size;
        double cm;
        int order;
        double total;
        double amount;
        double change;

        while (true) {

            try {

                String[] choices = {
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

                if (toppings.equals("Pepperoni")) {
                    price = 100;
                } else if (toppings.equals("Ham and Cheese")) {
                    price = 150;
                } else {
                    price = 200;
                }

                JOptionPane.showMessageDialog(null,
                    "You chose " + toppings +
                    "\nAdditional price: PHP " + price);

                String input = JOptionPane.showInputDialog(
                    "Enter Diameter in inches:");

                if (input == null) {
                    continue;
                }

                size = Double.parseDouble(input);
                cm = size * 2.54;
                input = JOptionPane.showInputDialog(
                    "Enter How Many Orders?");

                if (input == null) {
                    continue;
                }

                order = Integer.parseInt(input);
                total = ((cm * 5) + price) * order;

                JOptionPane.showMessageDialog(null,
                    "Your ordered " + toppings + " Pizza\n" +
                    "Size: " + cm + " cm\n" +
                    "Total Price: PHP " + total);

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
    }
}