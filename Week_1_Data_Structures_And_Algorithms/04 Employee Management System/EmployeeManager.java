public class EmployeeManager {
    private Employee[] arr;
    private int cnt;

    public EmployeeManager(int n) {
        arr = new Employee[n];
        cnt = 0;
    }

    public void addEmployee(Employee e) {
        if (cnt < arr.length) {
            arr[cnt++] = e;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < cnt; i++) {
            if (arr[i].getEmployeeId() == id) {
                return arr[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < cnt; i++) {
            System.out.println(arr[i]);
        }
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < cnt; i++) {
            if (arr[i].getEmployeeId() == id) {
                for (int j = i; j < cnt - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[--cnt] = null;
                return true;
            }
        }
        return false;
    }
}