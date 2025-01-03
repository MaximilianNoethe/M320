public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask(new PersonalTask("Buy groceries", "Buy milk, bread, and eggs", "2025-01-10"));
        taskManager.addTask(new WorkTask("Prepare presentation", "Finish slides for Monday's sprint review", "2025-01-08"));
        taskManager.addTask(new SchoolTask("Study", "Study at the library for an hour", "2025-01-07"));

        // Display all tasks
        taskManager.displayAllTasks();

        // Marking task as completed
        try {
            taskManager.completeTask(1);
        } catch (TaskException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Displaying all tasks to show the change
        taskManager.displayAllTasks();
    }
}