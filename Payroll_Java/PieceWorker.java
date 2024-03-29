
// PieceWorker class derived from Employee
public final class PieceWorker extends Employee {

	private double wagePerPiece; // wage per piece output
	private int quantity; // output for week

	// constructor for class PieceWorker
	public PieceWorker(String first, String last, double wage, int numberOfItems, int year, int month, int day,
			int hour, int mins, int sec) throws DateException {
		super(first, last, year, month, day, hour, mins, sec); // call superclass constructor
		setWage(wage);
		setQuantity(numberOfItems);
	}

	// set PieceWorker's wage
	public void setWage(double wage) {
		// Ternary operation that checks if there is a wage and assigns it that.
		wagePerPiece = (wage > 0 ? wage : 0);
	}

	// set number of items output
	public void setQuantity(int numberOfItems) {
		quantity = (numberOfItems > 0 ? numberOfItems : 0);
	}

	// determine PieceWorker's earnings
	public double earnings() {
		return quantity * wagePerPiece;
	}

	public String toString() {
		return "Piece worker: " + super.toString();
	}
}
