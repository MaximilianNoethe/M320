class PersonalTask extends Task {
    private String dueDate;

    public PersonalTask(String title, String description, String dueDate) {
        super(title, description);
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String getTaskType() {
        return "Personal";
    }
}