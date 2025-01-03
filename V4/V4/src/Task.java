abstract class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public abstract String getTaskType();

    @Override
    public String toString() {
        return "[" + getTaskType() + "] " + title + " - " + description + " (" + (completed ? "Completed" : "Pending") + ")";
    }
}
