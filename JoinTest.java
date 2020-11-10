import java.util.ArrayList;
import java.util.List;

class JoinTest {

    public static void main(String[] args) {
        // Список пользователей
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User(1, "Владимир", 1));
        userArrayList.add(new User(2, "Антон", 2));
        userArrayList.add(new User(3, "Александр", 6));
        userArrayList.add(new User(4, "Борис", 2));
        userArrayList.add(new User(5, "Юрий", 4));
        System.out.println("          User");
        for (User u : userArrayList) {
            System.out.println(u.id + " " + u.name + " " + u.d_id);
        }
        // Список отделов
        List<Department> departmentArrayList = new ArrayList<>();
        departmentArrayList.add(new Department(1, "Продажи"));
        departmentArrayList.add(new Department(2, "Поддержка"));
        departmentArrayList.add(new Department(3, "Финансы"));
        departmentArrayList.add(new Department(4, "Логистика"));
        System.out.println("          Department");
        for (Department d : departmentArrayList) {
            System.out.println(d.id + " " + d.name);
        }
        // Список пользователей с отделами
        List<UserDepartment> userDepartmentArrayList = new ArrayList<>();

        // Прямое соединение
        for (User u : userArrayList) {
            for (Department d : departmentArrayList) {
                if (u.d_id.equals(d.id)) {
                    userDepartmentArrayList.add(new UserDepartment(u.id,u.name,d.id, d.name));
                }
            }
        }
        System.out.println("          Прямое соединение - INNER JOIN ON D.id = U.d_id");
        for (UserDepartment ud : userDepartmentArrayList) {
            System.out.println(ud.user_id + " " + ud.user_name + " " + ud.department_id + " " + ud.department_name);
        }
        // Левое соединение
        userDepartmentArrayList = new ArrayList<>();
        for (User u : userArrayList) { // Все пользователи
            boolean e = false;
            for (Department d : departmentArrayList) { // Все отделы
                if (u.d_id.equals(d.id)) { // У пользователя есть отдел - добавляем
                    e = true; // отмечаем что есть отдел у пользователя
                    userDepartmentArrayList.add(new UserDepartment(u.id,u.name,d.id, d.name));
                }
            }
            if (!e) { // Отдела не нашлось - добавляем без отдела одну запись
                userDepartmentArrayList.add(new UserDepartment(u.id,u.name,null, null));
            }
        }
        System.out.println("          Левое соединение - LEFT JOIN ON D.id = U.d_id");
        System.out.println("            Дополняет выборку данными из левой таблицы, которые не подошли по условию");
        for (UserDepartment ud : userDepartmentArrayList) {
            System.out.println(ud.user_id + " " + ud.user_name + " " + ud.department_id + " " + ud.department_name);
        }
        // Правое соединение
        userDepartmentArrayList = new ArrayList<>();
        for (Department d : departmentArrayList) { // Все отделы
            boolean e = false;
            for (User u : userArrayList) { // Все пользователи
                if (u.d_id.equals(d.id)) { // У отдела есть пользователь - добавляем
                    e = true; // отмечаем что есть пользователь у отдела
                    userDepartmentArrayList.add(new UserDepartment(u.id,u.name,d.id, d.name));
                }
            }
            if (!e) { // Пользователя не нашлось - добавляем без пользователя одну запись
                userDepartmentArrayList.add(new UserDepartment(null,null,d.id, d.name));
            }
        }
        System.out.println("          Правое соединение - RIGHT JOIN ON D.id = U.d_id");
        System.out.println("            Дополняет выборку данными из правой таблицы, которые не подошли по условию");
        for (UserDepartment ud : userDepartmentArrayList) {
            System.out.println(ud.user_id + " " + ud.user_name + " " + ud.department_id + " " + ud.department_name);
        }
        // полное соединение
        userDepartmentArrayList = new ArrayList<>();
        // Сначала делаем левое соединение
        for (User u : userArrayList) { // Все пользователи
            boolean e = false;
            for (Department d : departmentArrayList) { // Все отделы
                if (u.d_id.equals(d.id)) { // У пользователя есть отдел - добавляем
                    e = true; // отмечаем что есть отдел у пользователя
                    userDepartmentArrayList.add(new UserDepartment(u.id,u.name,d.id, d.name));
                }
            }
            if (!e) { // Отдела не нашлось - добавляем без отдела одну запись
                userDepartmentArrayList.add(new UserDepartment(u.id,u.name,null, null));
            }
        }
        // Затем делаем правое соединение, но добавляем только отсутствующие
        for (Department d : departmentArrayList) { // Все отделы
            boolean e = false;
            for (User u : userArrayList) { // Все пользователи
                if (u.d_id.equals(d.id)) { // У отдела есть пользователь - добавляем
                    e = true; // отмечаем что есть пользователь у отдела
                    break;
                }
            }
            if (!e) { // Пользователя не нашлось - добавляем без пользователя одну запись
                userDepartmentArrayList.add(new UserDepartment(null,null,d.id, d.name));
            }
        }
        System.out.println("          Полное соединение - FULL JOIN ON D.id = U.d_id");
        System.out.println("            Дополняет выборку данными из левой таблицы, которые не подошли по условию");
        System.out.println("            Дополняет выборку данными из правой таблицы, которые не подошли по условию");
        for (UserDepartment ud : userDepartmentArrayList) {
            System.out.println(ud.user_id + " " + ud.user_name + " " + ud.department_id + " " + ud.department_name);
        }
        String name = userArrayList.stream()
                .max((u1,u2) -> u1.d_id.compareTo(u2.d_id))
                .get().name;
        System.out.println(name);
    }
}

class User {

    final Integer id;
    final String name;
    final Integer d_id;

    User(Integer id, String name, Integer d_id) {
        this.id = id;
        this.name = name;
        this.d_id = d_id;
    }
}

class Department {

    final Integer id;
    final String name;

    Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

class UserDepartment {

    final Integer user_id;
    final String user_name;
    final Integer department_id;
    final String department_name;

    UserDepartment(Integer user_id, String user_name, Integer department_id, String department_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.department_id = department_id;
        this.department_name = department_name;
    }
}
