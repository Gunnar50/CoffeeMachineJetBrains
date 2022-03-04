import java.util.Scanner;

public class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);
    int amountWater;
    int amountMilk;
    int amountCoffee;
    int disposableCups;
    int amountMoney;
    boolean running = true;

    CoffeeMachine(){
        amountWater = 400;
        amountMilk = 540;
        amountCoffee = 120;
        disposableCups = 9;
        amountMoney = 550;
    }

    public void start() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String option = scanner.next();
        switch (option) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                display();
                break;
            case "exit":
                running = false;
        }
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.next();
        switch (option) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                start();
                break;
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        amountWater += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        amountMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        amountCoffee += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
    }

    public void take() {
        System.out.println("I gave you $" + amountMoney);
        amountMoney = 0;
    }

    public boolean checkAmounts(int water, int milk, int coffee) {
        if ((amountWater >= water) && (amountMilk >= milk) && (amountCoffee >= coffee) && (disposableCups > 0)) {
            amountWater -= water;
            amountMilk -= milk;
            amountCoffee -= coffee;
            disposableCups--;
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else {
            if (amountWater < water) {
                System.out.println("Sorry, not enough water!");
                return false;
            } else if (amountMilk < milk) {
                System.out.println("Sorry, not enough milk!");
                return false;
            } else if (amountCoffee < coffee) {
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            } else {
                System.out.println("Sorry, not enough disposable cups!");
                return false;
            }
        }
    }

    public void espresso() {
        // 250 ml of water
        // 16 g of coffee beans
        // It costs $4
        if (checkAmounts(250, 0, 16)) amountMoney += 4;
    }

    public void latte() {
        // 350 ml of water
        // 75 ml of milk
        // 20 g of coffee
        // cost $7
        if (checkAmounts(350, 75, 20)) amountMoney += 7;
    }

    public void cappuccino() {
        // 200 ml of water
        // 100 ml of milk
        // 12 g of coffee beans
        // It costs $6
        if (checkAmounts(200, 100, 12)) amountMoney += 6;
    }

    public void display() {
        System.out.println("The coffee machine has:");
        System.out.println(amountWater + " ml of water");
        System.out.println(amountMilk + " ml of milk");
        System.out.println(amountCoffee + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + amountMoney + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.running) {
            coffeeMachine.start();
        }

    }
}
