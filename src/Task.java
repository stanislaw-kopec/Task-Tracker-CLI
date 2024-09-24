import java.time.LocalDateTime;

public class Task {
    public static int counter = 0;

    public final int id;
    private String description;
    private Status taskStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task() {
        this.id = ++counter;
        this.createdAt = LocalDateTime.now();
        this.taskStatus = Status.TODO;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }
}
