public class Main {
    public static void main(String[] args) {
        EmployeeManager obj = new EmployeeManager(5);

        Employee e1 = new Employee(1, "Alice", "Developer", 60000);
        Employee e2 = new Employee(2, "Bob", "Manager", 80000);
        Employee e3 = new Employee(3, "Charlie", "Analyst", 50000);

        obj.addEmployee(e1);
        obj.addEmployee(e2);
        obj.addEmployee(e3);

        System.out.println("Employees after adding:");
        obj.traverseEmployees();

        Employee x = obj.searchEmployee(2);
        System.out.println("Searched Employee with ID 2: " + x);

        boolean ok = obj.deleteEmployee(1);
        System.out.println("Employee with ID 1 deleted: " + ok);

        System.out.println("Employees after deletion:");
        obj.traverseEmployees();

        Employee e4 = new Employee(4, "Diana", "Designer", 55000);
        obj.addEmployee(e4);

        System.out.println("Employees after adding a new employee:");
        obj.traverseEmployees();
    }
}