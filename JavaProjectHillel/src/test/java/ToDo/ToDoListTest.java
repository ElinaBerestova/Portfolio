package ToDo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoListTest {
    @Test
    public void addTodoTest() {
        ToDoList todos = new ToDoList();
        todos.add("Buy smth");
        Assert.assertEquals(todos.getTodos().size(), 1);
        todos.getTodos();
    }
    @Test
    public void removeTodoTest() {
        ToDoList todos = new ToDoList();
        todos.add("Buy smth");
        Assert.assertEquals(todos.getTodos().size(), 1);
        todos.remove("Buy smth");
        Assert.assertEquals(todos.getTodos().size(), 0);
    }
}
