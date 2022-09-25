package ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> todos;

    public ToDoList() {
        this.todos = new ArrayList<>();
    }

    public void add(String todo) {
        todos.add(todo);
    }

    public void remove(String todo) {
        todos.remove(todo);
    }

    public List<String> getTodos() {
        return this.todos;
    }

}
