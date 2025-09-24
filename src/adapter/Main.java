package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2025);
        date.setMonth(9);
        date.setDay(24);

        System.out.println("Initial Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(10);

        System.out.println("After advancing 10 days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(30);

        System.out.println("After advancing 30 days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}

