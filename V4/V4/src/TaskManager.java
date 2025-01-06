import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void completeTask(int index) throws TaskException {
        if (index < 0 || index >= tasks.size()) {
            throw new TaskException("Invalid task index: " + index);
        }
        tasks.get(index).markAsCompleted();
        System.out.println("Task marked as completed: " + tasks.get(index));
    }

    public void displayAllTasks() {
        System.out.println("\nAll Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }
}