package tamk.ohsyte;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.MonthDay;
import java.util.Collections;
import java.util.List;

public class Today {
    public static void main(String[] args) {
        // Get the user's home directory
        String userHome = System.getProperty("user.home");
        Path filePath = Paths.get(userHome, ".today", "events.csv");

        // Check if the file exists
        File file = filePath.toFile();
        if (!file.exists()) {
            System.err.println("Directory or file not found: " + filePath);
            return;
        }

        EventProvider provider = new CSVEventProvider(filePath.toString());

        final MonthDay monthDay = MonthDay.of(2, 10);

        // Get events for given day, any year, any category, newest first
        List<Event> events = provider.getEventsOfDate(monthDay);
        Collections.sort(events);
        Collections.reverse(events);

        for (Event event : events) {
            System.out.println(event);
        }
    }
}