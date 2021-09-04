
// Boss class derived from Employee.
public final class Boss extends Employee {

	private double weeklySalary;

	// constructor for class Boss
	public Boss(String first, String last, double salary, int year, int month, int day, int hour, int mins, int sec)
			throws DateException {

		super(first, last, year, month, day, hour, mins, sec); // call superclass constructor

		setWeeklySalary(salary);
	}

	// set Boss's salary
	public void setWeeklySalary(double salary) {
		// Ternary operation that checks if there is a salary and assigns it that.
		weeklySalary = (salary > 0 ? salary : 0);
	}

	// get Boss's pay
	public double earnings() {
		return weeklySalary;
	}

	// get String representation of Boss's name
	public String toString() {
		return "Boss: " + super.toString();
	}
} // end class Boss
