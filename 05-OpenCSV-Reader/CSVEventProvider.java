package tamk.ohsyte;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;



public class CSVEventProvider implements EventProvider {
    private final List<Event> events;

    public CSVEventProvider(String fileName) {
        this.events = new ArrayList<>();

        Path path = Paths.get(fileName);
        try (CSVReader reader = new CSVReader(new FileReader(path.toFile()))) {
            List<String[]> lines = reader.readAll();

            for (String[] line : lines) {
                this.events.add(makeEvent(line));
            }

            System.out.printf("Read %d events from CSV file%n", this.events.size());
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file '" + fileName + "': " + e.getMessage());
        }
    }


    @Override
    public List<Event> getEvents() {
        return this.events;
    }

    @Override
    public List<Event> getEventsOfCategory(Category category) {
        List<Event> result = new ArrayList<Event>();
        for (Event event : this.events) {
            if (event.getCategory().equals(category)) {
                result.add(event);
            }
        }
        return result;
    }

    @Override
    public List<Event> getEventsOfDate(MonthDay monthDay) {
        List<Event> result = new ArrayList<Event>();

        for (Event event : this.events) {
            final Month eventMonth = event.getDate().getMonth();
            final int eventDay = event.getDate().getDayOfMonth();
            if (monthDay.getMonth() == eventMonth && monthDay.getDayOfMonth() == eventDay) {
                result.add(event);
            }
        }

        return result;
    }

    private Event makeEvent(String[] parts) {
        LocalDate date = LocalDate.parse(parts[0]);
        String description = parts[1];
        String categoryString = parts[2];
        String[] categoryParts = categoryString.split("/");
        String primary = categoryParts[0];
        String secondary = null;
        if (categoryParts.length == 2) {
            secondary = categoryParts[1];
        }
        Category category = new Category(primary, secondary);
        return new Event(date, description, category);
    }
}
