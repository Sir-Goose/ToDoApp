import java.util.ArrayList;
import java.util.Scanner;

public class WorkerClass {
    ArrayList<String> tasks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    // default constructor
    public WorkerClass() {
        //
    }
    public void start() {
        menu();
    }

    public void display() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Tasks: ");
        for(String task : tasks) {
            System.out.println(task);
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Add task | 2. Delete task | 4. Exit");

    }
    public void deleteTask() {
        int taskNumber;
        System.out.println("Enter task number: ");
        taskNumber = scanner.nextInt();
        scanner.nextLine();
        tasks.remove(taskNumber - 1);
    }
    public void quit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
    public void menu() {
        int choice;
        do {
            display();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while(choice != 4);
    }

    public void addTask() {
        String task;
        System.out.println("Enter task: ");
        task = scanner.nextLine();
        int i = tasks.size() + 1;

        task = "(" + i + ") " + task;

        tasks.add(task);
    }

}
