import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		System.out.println("Dia "+day+" Mes: "+month+" Año: "+ year);
	}
}
