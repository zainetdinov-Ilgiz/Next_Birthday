import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your date of birth in the format dd-mm-yyyy");
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate birthday = null;
        LocalDate nextBirthday ;
        boolean flag = true;
        do {
            try {
                birthday = LocalDate.parse(scanner.next(), formatter);
                flag=false;
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("You entered the wrong date, please try again");
            }
        } while (flag);
        scanner.close();
        if (currentDate.isAfter(birthday.withYear(currentDate.getYear()))){
            nextBirthday = birthday.withYear(currentDate.getYear()+1);
        } else {
            nextBirthday = birthday.withYear(currentDate.getYear());
        }
        System.out.printf("Until the next birthday %d days", ChronoUnit.DAYS.between(currentDate,nextBirthday));
    }
}
