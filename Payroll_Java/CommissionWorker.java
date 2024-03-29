// CommissionWorker class derived from Employee

public final class CommissionWorker extends Employee {

	private double salary; // base salary per week
	private double commission; // amount per item sold
	private int quantity; // total items sold for week

	// constructor for class CommissionWorker
	public CommissionWorker(String first, String last, double salary, double commission, int quantity, int year,
			int month, int day, int hour, int mins, int sec) throws DateException {
		super(first, last, year, month, day, hour, mins, sec); // call superclass constructor
		setSalary(salary);
		setCommission(commission);
		setQuantity(quantity);
	}

	// set CommissionWorker's weekly base salary
	public void setSalary(double weeklySalary) {
		// Ternary operation that checks if there is a salary and assigns it that.
		salary = (weeklySalary > 0 ? weeklySalary : 0);
	}

	// set CommissionWorker's commission
	public void setCommission(double itemCommission) {
		commission = (itemCommission > 0 ? itemCommission : 0);
	}

	// set CommissionWorker's quantity sold
	public void setQuantity(int totalSold) {
		quantity = (totalSold > 0 ? totalSold : 0);
	}

	// determine CommissionWorker's earnings
	public double earnings() {
		return salary + commission * quantity;
	}

	// get String representation of CommissionWorker's name
	public String toString() {
		return "Commission worker: " + super.toString();
	}
} // end class CommissionWorker
