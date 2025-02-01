import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;


public class EventDemo {
    public static void main(String[] args) {
        Category macosCategory = new Category("apple", "macos");

        List<Event> events = new ArrayList<>();
        events.add(new Event( LocalDate.of(2024,9,16), "macOS 15 Sequoia released", macosCategory ));
        events.add(new Event(LocalDate.of(2023, 9, 26), "macOS 14 Sonoma released", macosCategory));
        events.add(new Event(LocalDate.of(2022, 10, 24), "macOS 13 Ventura released", macosCategory));
        events.add(new Event(LocalDate.of(2021, 10, 25), "macOS 12 Monterey released", macosCategory));
        events.add(new Event(LocalDate.of(2020, 11, 12), "macOS 11 Big Sur released", macosCategory));
        for (Event event : events) {
            String description = event.getDescription();

            // print [macOS 15 Sequoia released]
            int index1 = description.indexOf(" ") + 1; // First space after "macOS"
            int index2 = description.indexOf(" ", index1); // Space after version number

            String version = description.substring(index1, index2); // Extracts version
            String name = description.substring(index2 + 1, description.indexOf(" released")); // Extracts name

            String weekDay = event.getDate().getDayOfWeek().toString();
            weekDay = weekDay.charAt(0)+ weekDay.substring(1).toLowerCase();

            StringBuilder output = new StringBuilder();
            output.append("macOS ")
                    .append(version)
                    .append(" ")
                    .append(name)
                    .append(" was released on a ")
                    .append(weekDay);

            System.out.println(output);

            /* *** my approach ***

            String[] words = description.split(" ");
            String version = words[1];
            String name = words[2];

            System.out.println("macos " + version + " " + name + " was released on a " + weekDay);
            * */
        }

        // Collect macOS names
        String[] names = new String[events.toArray().length];

        for (int i = 0; i < names.length; i++) {
            String description = events.get(i).getDescription();
            int index1 = description.indexOf(" ") + 1; // Find second space
            names[i] = description.substring(index1, description.indexOf(" released")); // Extract name
        }

        /*  *** my approach ***
        *  String[] names = new String[events.size()];
        * for (int i = 0; i < events.size(); i++) {
        * names[i] = events.get(i).getDescription().split(" ")[2]; // Extract names
        }
        * */



        Arrays.sort(names);
        System.out.println("In alphabetical order: " + Arrays.toString(names));

    }
}
