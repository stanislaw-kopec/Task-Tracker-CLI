import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Operations operations = new Operations();

        System.out.println("What do you want?");
        System.out.println("(add/update/delete/print-all/exit)");

        do {
            String instruction = scanner.nextLine();

            String[] parts = instruction.split(" ",2);
            String command = parts[0];
            String parameter = (parts.length > 1) ? parts[1] : "";

            switch (command) {
                case "add":
                    System.out.println("Adding a task...");
                    operations.add(parameter);
                    break;
                case "update":
                    System.out.println("Updating the task...");
                    break;
                case "delete":
                    System.out.println("Deleting the task...");
                    break;
                case "print-all":
                    System.out.println("Printing all the tasks...");
                    operations.printAll();
                    break;
                case "exit":
                    System.out.println("See you soon!");
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect instruction.");
            }
        } while (!exit);
    }
}