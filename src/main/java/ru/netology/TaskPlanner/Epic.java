package ru.netology.TaskPlanner;

public class Epic extends Task {
    protected String[] subTasks;

    public Epic(int id, String[] subTasks) {
        super(id); // вызов родительского конструктора
        this.subTasks = subTasks; // заполнение своих полей
    }

    public String[] getSubTasks() {

        return subTasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subTask : subTasks) {
            if (subTask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
