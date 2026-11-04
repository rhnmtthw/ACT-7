public class PIZZA {

    String toppings;
    String discount;
    String cardNumber;

    int Diameter;
    int HowMany;

    double price;

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setDiameter(int Diameter) {
        this.Diameter = Diameter;
    }

    public void setHowMany(int HowMany) {
        this.HowMany = HowMany;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public String getToppings() {
        return toppings;
    }

    public int getDiameter() {
        return Diameter;
    }

    public int getHowMany() {
        return HowMany;
    }

    public String getDiscount() {
        return discount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getPrice() {
        return price;
    }


    public void computePrice() {

        double toppingPrice = 0;

        double centimeter = Diameter * 2.54;

        if (toppings.equalsIgnoreCase("Pepperoni")) {
            toppingPrice = 100;
        }
        else if (toppings.equalsIgnoreCase("Ham and Cheese")) {
            toppingPrice = 150;
        }
        else if (toppings.equalsIgnoreCase("Hawaiian")) {
            toppingPrice = 200;
        }

        price = toppingPrice + (centimeter * 5);

        price = price * HowMany;

        if (discount.equalsIgnoreCase("Senior-PWD")) {
            price = price * 0.80;
        }
        else if (discount.equalsIgnoreCase("VIP")) {
            price = price * 0.88;
        }

    }

}