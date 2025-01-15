import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner; // import the Scanner class

public class RandomInteger {


        public static void main(String[] args) {
            Random r = new Random();
            int value = r.nextInt(100) + 1;


            Scanner scanner = null;
            for (int i = 1; i <= 7; i++) {
                scanner = new Scanner(System.in);
                System.out.println("Arvaa jokin numero 1 - 100 välillä");
                try {
                    int userInput = scanner.nextInt();
                    if (userInput < 1 || userInput > 100) {
                        System.out.println("Väärä syöte, laitta numero 0-100 kuten esimerkissa");
                        i--;
                        continue;

                    }
                    if (userInput == value) {
                        System.out.println(" Voitto!!! Oikein Arvasit!");
                        break;
                    } else if (userInput < value) {
                        System.out.println("Liian pieni luku.");

                    } else if (userInput > value) {
                        System.out.println("Liian iso luku.");
                    }
                    if (i == 7) {
                        System.out.println(String.format("sinä arvasit %d kerta väärin peli päätyy.", i));
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println(" Väärä syöte,  laitta numerot muodoss 1-100");
                    scanner.next();
                    i--;

                }
            } scanner.close();

        }
}


