import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkerClass {
    private ArrayList<String> tasks;
    private Scanner scanner;
    private final String FILE_NAME = "tasks.txt";

    public WorkerClass() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadTasksFromFile();
    }

    public void start() {
        menu();
    }

    public void display() {
        int i = 1;
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Tasks: ");
        for (String task : tasks) {
            System.out.print("(" + i + ") ");
            System.out.println(task);
            i++;
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Add task | 2. Delete task | 3. Exit");
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
        saveTasksToFile();
        System.exit(0);
    }

    public void menu() {
        int choice;
        do {
            display();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 3);
    }

    public void addTask() {
        String task;
        System.out.println("Enter task: ");
        task = scanner.nextLine();
        tasks.add(task);
    }

    private void loadTasksFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tasks = (ArrayList<String>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No tasks found. Starting with an empty list.");
        }
    }

    private void saveTasksToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tasks);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Unable to save tasks.");
        }
    }
}

