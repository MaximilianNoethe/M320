class SchoolTask extends Task {
    private String deadline;

    public SchoolTask(String title, String description, String deadline) {
        super(title, description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String getTaskType() {
        return "School";
    }
}
