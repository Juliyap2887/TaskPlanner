import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.TaskPlanner.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test1() { // возвращает пустой массив, если нет совпадений
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Сварить кофе"));
        todos.add(new Epic(2, new String[]{"Сделать ДЗ"}));

        Task[] expected = {};
        Task[] actual = todos.search("Помыть полы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() { // возвращает массив задач с одним совпадением
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Сварить кофе"));
        todos.add(new Epic(2, new String[]{"Сделать ДЗ"}));

        Task[] expected = {new SimpleTask(1, "Сварить кофе")};
        Task[] actual = todos.search("кофе");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() { //если запроса нет, должны возвращаться все задачи
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Сварить кофе"));
        todos.add(new Epic(2, new String[]{"Сделать ДЗ"}));

        Task[] expected = {new SimpleTask(1, "Сварить кофе"), new Epic(2, new String[]{"Сделать ДЗ"})};
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }
}
