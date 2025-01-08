import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.TaskPlanner.Epic;
import ru.netology.TaskPlanner.Meeting;
import ru.netology.TaskPlanner.SimpleTask;

public class TasksTest {
    @Test
    public void test1() { // Запрос содержится в названии
        SimpleTask task = new SimpleTask(1, "Купить хлеб");
        String query = "Купить";
        boolean expected = true;
        boolean actual = task.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() { // Запрос не содержится в названии
        SimpleTask task = new SimpleTask(1, "Купить хлеб");
        String query = "Продать";
        boolean expected = false;
        boolean actual = task.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() { // Запрос содержится в задаче
        String[] subtasks = {"Молоко", "Кофе", "Батон"};
        Epic epic = new Epic(2, subtasks);
        String query = "Кофе";
        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() { // Запрос не содержится в задаче
        String[] subtasks = {"Молоко", "Кофе", "Батон"};
        Epic epic = new Epic(2, subtasks);
        String query = "Чай";
        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test5() { // Запрос содержится в названии проекта
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "НетоБанк";
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test6() { // Запрос содержится в теме встречи
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Выкатка";
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test7() { // Запрос не содержится ни в теме встречи, ни в названии проекта
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Запрос";
        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}
