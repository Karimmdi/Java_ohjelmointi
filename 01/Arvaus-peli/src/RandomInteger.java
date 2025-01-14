import java.util.Random;
import java.util.Scanner; // import the Scanner class

public class RandomInteger {


        public static void main(String[] args) {
            Random r = new Random();
            int value = r.nextInt(100) +1;


            for (int i = 1; i < value; i++) {

                Scanner scanner = new Scanner(System.in);
                // Enter username and press Enter
                System.out.println("Arvaa joku numero 1 - 100\n");
                int userInput = scanner.nextInt();
                if (userInput == value) {
                    System.out.println("Oeikein Arvasit");
                }
                if (userInput > value) {
                    System.out.println("Liian iso luku.");
                }
                if (userInput < value) {
                    System.out.println("Liian pieni luku.");
                }




            }
        }
}


