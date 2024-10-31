package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("AUDI", 51);
        Car car2 = new Car("TOYOTA", 178);
        Car car3 = new Car("MAZDA", 750);
        Car car4 = new Car("OPEL", 95);

        userService.add(new User("Ivan", "Ivanov", "zero@yandex.ru", "30", car4));
        userService.add(new User("Jonny", "Boy", "to-first@gmail.ru", "21", car1));
        userService.add(new User("Tomas", "Mraz", "second@rambler.ru", "27", car2));
        userService.add(new User("Olya", "Arbuzova", "buzova88@bk.ru", "38", car3));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("Name = " + user.getName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("__________________________________");
        }


        User user = userService.findUserByCar("AUDI", 51);
        System.out.println(user);

        context.close();


    }
}