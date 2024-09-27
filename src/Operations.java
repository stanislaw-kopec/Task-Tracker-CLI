import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Operations extends Task {
    public static ArrayList<Task> tasks = new ArrayList<>();

    public void add(String description) {
        Task task = new Task();
        task.setDescription(description);
        tasks.add(task);
    }

    public void delete(int taskId) {
        if (getPositionById(taskId) != -1) {
            tasks.remove(getPositionById(taskId));
        } else {
            System.out.println("Task did not exist");
        }
    }

    public void update(String command) {
        String[] parts = command.split(" ", 2);
        int taskId = getPositionById(Integer.parseInt(parts[0]));
        String description = parts[1];

        Task task = tasks.get(taskId);
        task.setDescription(description);
        task.setUpdatedAt();
        tasks.set(taskId, task);
    }

    public void markTask(String command) {
        String[] parts = command.split(" ", 2);
        int taskId = getPositionById(Integer.parseInt(parts[0]));
        String taskStatus = parts[1];

        Task task = tasks.get(taskId);
        if (enumContains(taskStatus)) {
            task.setTaskStatus(Status.valueOf(taskStatus.toUpperCase()));
            task.setUpdatedAt();
        } else {
            System.out.println("Incorrect status.");
        }
    }

    public int getPositionById(int taskId) {
        int i = 0;
        for (Task task : tasks) {
            if (task.id == taskId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean enumContains(String str) {
        for (Status status : Status.values()) {
            if (status.name().equals(str.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

//    public static boolean isInteger(String str) {
//        try {
//            Integer.parseInt(str);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }

    public void printAll() {
        for (Task task : tasks){
            System.out.println("===============================");
            System.out.println("ID: " + task.id);
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getTaskStatus());
            System.out.println("Created at: " + task.getCreatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            System.out.println("Modified at: " + task.getUpdatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
    }
}
