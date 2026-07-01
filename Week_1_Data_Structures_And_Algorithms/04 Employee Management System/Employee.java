public class Employee {
    private int id;
    private String n;
    private String pos;
    private double sal;

    public Employee(int i, String name, String p, double s) {
        id = i;
        n = name;
        pos = p;
        sal = s;
    }

    public int getEmployeeId() {
        return id;
    }

    public void setEmployeeId(int i) {
        id = i;
    }

    public String getName() {
        return n;
    }

    public void setName(String name) {
        n = name;
    }

    public String getPosition() {
        return pos;
    }

    public void setPosition(String p) {
        pos = p;
    }

    public double getSalary() {
        return sal;
    }

    public void setSalary(double s) {
        sal = s;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + id +
                ", name='" + n + '\'' +
                ", position='" + pos + '\'' +
                ", salary=" + sal +
                '}';
    }
}