import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Birthday {
    public static void main(String[] args) {
        // Hae ympäristömuuttuja "BIRTHDATE"
        String birthdateEnv = System.getenv("BIRTHDATE");

        if (birthdateEnv == null || birthdateEnv.isEmpty()) {
            System.out.println("Virhe: Ympäristömuuttujaa BIRTHDATE ei löytynyt tai se on tyhjä.");
            return;
        }

        try {
            // Muunna ympäristömuuttujan arvo LocalDate-objektiksi
            LocalDate birthdate = LocalDate.parse(birthdateEnv);
            LocalDate today = LocalDate.now(); // Hae nykyinen päivämäärä
            long ageInDays = ChronoUnit.DAYS.between(birthdate, today); // Laske ikä päivissä

            // Tarkista, onko tänään käyttäjän syntymäpäivä
            if (birthdate.getMonth() == today.getMonth() && birthdate.getDayOfMonth() == today.getDayOfMonth()) {
                System.out.println("Hyvää syntymäpäivää!");
                int birthYear = birthdate.getYear();
                if (birthYear % 1000 == 0) {
                    System.out.println("Se on pyöreä luku!");
                }
            } else {
                System.out.println("Tänään ei ole syntymäpäiväsi. Hyvää päivää!");
                System.out.println("Olet " + ageInDays + " päivää vanha!");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Virhe: BIRTHDATE-ympäristömuuttujan arvo ei ole kelvollinen päivämäärä. Käytä muotoa YYYY-MM-DD.");
        }
    }

}
