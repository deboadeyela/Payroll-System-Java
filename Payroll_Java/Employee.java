
//Importing necessary libraries.
import java.text.DecimalFormat;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;

//The parent class. All global variables are accessible to all extended child classes.
public abstract class Employee {

	// Initialising variables
	private String firstName;
	private String lastName;
	LocalDate localDate;
	String currentDate;

	int year, month, day, hour, mins, sec;
	int daysInMonth, dayOfWeek;

	String yearFormatted, monthFormatted, dayFormatted;

	// constructor throws DateException
	public Employee(String first, String last, int year, int month, int day, int hour, int mins, int sec)
			throws DateException {

		this.firstName = first;
		this.lastName = last;

		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.mins = mins;
		this.sec = sec;

		// Getting current date in dd-mm-yyyy format
		LocalDate localDate = new LocalDate();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
		currentDate = fmt.print(localDate);

	}

	// get first name
	public String getFirstName() {
		return firstName;
	}

	// get last name
	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return firstName + ' ' + lastName;
	}

	// Method returning the joinDate.
	public String getJoinDate() {
		// Formatter ensures that a single digit number will be displayed as two digits.
		// E.G. 1 => 01.
		DecimalFormat decimalFormatter = new DecimalFormat("00");
		dayFormatted = decimalFormatter.format(day);
		monthFormatted = decimalFormatter.format(month);
		yearFormatted = decimalFormatter.format(year);
		return dayFormatted + "/" + monthFormatted + "/" + yearFormatted;
	}

	// Method returning the joinTime.
	public String getJoinTime() {
		// Formatter ensures that a single digit number will be displayed as two digits.
		// E.G. 1 => 01.
		DecimalFormat decimalFormatter = new DecimalFormat("00");
		String hourFormatted = decimalFormatter.format(hour);
		String minFormatted = decimalFormatter.format(mins);
		String secFormatted = decimalFormatter.format(sec);
		return hourFormatted + ":" + minFormatted + ":" + secFormatted;

	}

	// Method that checks if the date is valid.
	// Throws a user defined exception if it isn't valid.
	public void checkDate() throws DateException {
		// Valid Year Check
		if (year < 1990) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n" + "Reason: The Join Year " + ""
					+ year + " is before 1990.");
		}

		// Valid Month Check
		if (month > 12 || month < 1) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
					+ "Reason: The month is out of range. Month needs to be in range of [1-12].");
		}

		// Dummy used to find the number of days in a month, assuming day, hour, minute,
		// second, and millisecond is right.
		DateTime dateTimeDummy = new DateTime(year, month, 1, 12, 12, 00, 000);
		// Finds the number of days in a month given year and month.
		daysInMonth = dateTimeDummy.dayOfMonth().getMaximumValue();

		// Valid date range check.
		// Checks if the day is greater than the days in the month.
		if (day > daysInMonth) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
					+ "Reason: The date you entered exceeds the date range for the month of " + monthFormatted + "."
					+ "\n" + "The date range for this month is: [1-" + daysInMonth + "].");
		}
		// Checks if the day is lesser than the days in the month.
		if (day <= 0) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
					+ "Reason: The date you entered preceeds the date range for the month of " + monthFormatted + "."
					+ "\n" + "The date range for this month is: [1-" + daysInMonth + "].");
		}

		// Valid Hour Check
		if ((hour < 9) || (hour > 18)) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
					+ "Reason: The time you entered (" + getJoinTime() + ") " + "is out of our range (9:00 - 18:00)");
		}

		// Valid Hour + Minute Check
		if ((hour == 18) && (mins > 0)) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
					+ "Reason: The time you entered (" + getJoinTime() + ") " + "is out of our range (9:00 - 18:00)");
		}

		// Check if weekend.
		DateTime dateTimeDummy2 = new DateTime(year, month, day, 12, 12, 00, 000);
		// Day of week is an Enum which represents the 7 days of the week.
		// 6 && 7 is Saturday and Sunday, which is the weekend.
		dayOfWeek = dateTimeDummy2.getDayOfWeek();

		// Checks if it is Saturday or Sunday.
		if ((dayOfWeek == 6) || (dayOfWeek == 7)) {
			throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
					+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
					+ "Reason: The date you entered " + getJoinDate() + " falls on a weekend.");
		}

		// Gets the month and formats it to English.
		DateTime dateTimeDummy3 = new DateTime(year, month, day, 12, 12, 00, 000);
		DateTimeFormatter monthFormatter = DateTimeFormat.forPattern("MMMM");
		String monStr = monthFormatter.print(dateTimeDummy3.getMonthOfYear());

		// Check if the date is in the future

		if (year >= (LocalDate.now().getYear())) { // Checks if the year is greater or equal.
			if (year > (LocalDate.now().getYear())) { // Checks if the year is greater
				throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
						+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
						+ "Reason: The year you entered " + year + " is in the future! " + "\n"
						+ "The year can't be in the future, the date needs to be in the range: [1-1-1990 - "
						+ currentDate + "].");
			} else {
				if (month > (LocalDate.now().getMonthOfYear())) { // Checks if the month is greater given the year is
																	// same.
					throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
							+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
							+ "Reason: The month you entered " + monStr + " is in the future! " + "\n"
							+ "The month can't be in the future, the date needs to be in the range: [1-1-1990 - "
							+ currentDate + "].");
				} else {
					if (day > (LocalDate.now().getDayOfMonth())) { // Checks if the day is greater given the month and
																	// year is the same.
						throw new DateException("\n" + getFirstName() + " " + getLastName() + "'s" + " " + "join date ("
								+ getJoinDate() + " " + getJoinTime() + ") " + "is invalid." + "\n"
								+ "Reason: The day you entered " + day + " is in the future! " + "\n"
								+ "The day can't be in the future, the date needs to be in the range: [1-1-1990 - "
								+ currentDate + "].");
					}
				}
			}
		}

	}

	public abstract double earnings();
}
