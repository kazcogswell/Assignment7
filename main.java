
/**
 * This program is a simple ATM machine. It accepts any user and card number,
 * there is one pin, and a menu.
 *
 * @author Kaz Cogswell
 * @version 4-30-19
 */

public class main
{
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.setIntBalance();
        System.out.println("Welcome to the ATM.");
        atm.setCardName();

    }
}