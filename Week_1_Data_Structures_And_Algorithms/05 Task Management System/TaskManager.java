import java.util.Scanner;

class Task {
    int id;
    String name;
    String state;

    public Task(int i, String n, String s) {
        id = i;
        name = n;
        state = s;
    }

    @Override
    public String toString() {
        return "TaskId: " + id + ", TaskName: " + name + ", Status: " + state;
    }
}

class Node {
    Task data;
    Node next;

    public Node(Task t) {
        data = t;
        next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void addTask(Task t) {
        Node x = new Node(t);

        if (head == null) {
            head = x;
            return;
        }

        Node cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = x;
    }

    public Task searchTask(int id) {
        Node cur = head;

        while (cur != null) {
            if (cur.data.id == id) {
                return cur.data;
            }
            cur = cur.next;
        }

        return null;
    }

    public void traverse() {
        Node cur = head;

        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null)
            return;

        if (head.data.id == id) {
            head = head.next;
            return;
        }

        Node cur = head;

        while (cur.next != null && cur.next.data.id != id) {
            cur = cur.next;
        }

        if (cur.next != null) {
            cur.next = cur.next.next;
        }
    }
}

public class TaskManager {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        SinglyLinkedList obj = new SinglyLinkedList();

        System.out.println("Enter the number of tasks you want to add:");
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter task ID:");
            int id = in.nextInt();
            in.nextLine();

            System.out.println("Enter task name:");
            String name = in.nextLine();

            System.out.println("Enter task status (Incomplete/Complete):");
            String state = in.nextLine();

            obj.addTask(new Task(id, name, state));
        }

        System.out.println("\nTasks in the list:");
        obj.traverse();

        System.out.println("\nEnter task ID to search:");
        int key = in.nextInt();

        Task t = obj.searchTask(key);

        if (t != null)
            System.out.println("Found Task: " + t);
        else
            System.out.println("Task not found.");

        System.out.println("\nEnter task ID to delete:");
        int del = in.nextInt();

        obj.deleteTask(del);
        System.out.println("\nTasks in the list after deletion:");
        obj.traverse();
        in.close();
    }
}