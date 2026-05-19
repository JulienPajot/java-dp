public final class DateUtils {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private DateUtils() {
    }

    public static LocalDateTime toDate(String dateStr) {
        return LocalDateTime.parse(dateStr, FORMATTER);
    }
}