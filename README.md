# Payroll-System-Java
Java Program that emulates a Payroll System for a company. Payroll system includes a private instance variable called joinDate in class Employee to represent when they joined the company.  

The Joda-Time library class LocalDate is used as the type for this variable. A static variable in the Employee class is used to help automatically assign each new employee a unique (incremental) id number. 

The Earnings() method in Employee and all sub-classes throw a user defined Exception if the total earnings are less than the equivalent of €10 per hour, as this is defined this amount is considered minimum wage. 

When an exception is encountered calculating an employee's earnings, the Test class should print out the error message and continue as normal with the next employees.
