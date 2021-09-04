
// Driver for Employee hierarchy
// Java extension packages
import javax.swing.JOptionPane;

public class Test {

	//Define new objects
	static Boss boss;
	static CommissionWorker commissionWorker;
	static HourlyWorker hourlyWorker;
	static PieceWorker pieceWorker;

	// test Employee hierarchy
	public static void main(String args[]) throws DateException {
		String output = "";

		//Array which creates new objects
		Employee[] myEmployees = new Employee[10];
		myEmployees[0] = new Boss("John", "Smith", 800.0, 1985, 6, 30, 13, 12, 00);
		myEmployees[1] = new Boss("Markus", "Graham", 800.0, 2020, 8, 4, 10, 23, 00);
		myEmployees[2] = new Boss("Lucas", "Fowlers", 800.0, 1996, 2, 29, 9, 35, 00);
		myEmployees[3] = new CommissionWorker("Mary", "Cuoco", 400.0, 3.0, 150, 2010, 13, 9, 14, 45, 00);
		myEmployees[4] = new CommissionWorker("Lucy", "Jacob", 400.0, 3.0, 150, 2008, 10, 27, 8, 33, 00);
		myEmployees[5] = new CommissionWorker("Sarah", "Dunphy", 400.0, 3.0, 150, 2003, 1, 18, 11, 14, 00);
		myEmployees[6] = new PieceWorker("Bob", "Foley", 2.5, 200, 1999, 2, 30, 16, 11, 00);
		myEmployees[7] = new PieceWorker("Liam", "Fallon", 2.5, 200, 2015, 7, 8, 18, 37, 00);
		myEmployees[8] = new HourlyWorker("Karen", "Price", 13.75, 40, 1989, 12, 12, 19, 25, 00);
		myEmployees[9] = new HourlyWorker("Susan", "Shanley", 13.75, 40, 2019, 2, 29, 3, 40, 00);

		//Loops through array and checks if the date is valid.
		//Throws date exception if it isn't valid.
		//Outputs to a string if it is valid.
		for (Employee employee : myEmployees) {
			try {
				employee.checkDate();
				output += employee.toString() + "\n" + employee.getJoinDate() + "\n";
			} catch (DateException dateException) {
				//Catches the exception and prints it out.
				String errorMessage = dateException.getMessage();
				JOptionPane.showMessageDialog(null, errorMessage, "Assignment 2", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		JOptionPane.showMessageDialog(null, output, "Assignment 2", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}
} // end class Test
