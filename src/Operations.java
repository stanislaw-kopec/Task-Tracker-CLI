import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Operations extends Task {
    public static ArrayList<Task> tasks = new ArrayList<>();

    public void add(String description) {
        Task task = new Task();
        task.setDescription(description);
        tasks.add(task);
    }

    public void printAll() {
        for (Task task : tasks){
            System.out.println("===============================");
            System.out.println("ID: " + task.id);
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getTaskStatus());
            System.out.println("Created at: " + task.getCreatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
    }
}
