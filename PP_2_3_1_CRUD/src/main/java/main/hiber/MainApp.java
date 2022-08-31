package main.hiber;

import main.hiber.config.AppConfig;
import main.hiber.entity.User;
import main.hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.dropTable("users");

        userService.add(new User("Anna", "Ozhigova", 24, "Austria"));
        userService.add(new User("Dmitriy", "Salikhov", 25, "Russia"));
        userService.add(new User("Artem", "Lebedev", 28, "Russia"));
        userService.add(new User("Anastasia", "Perten", 27, "Russia"));
        userService.add(new User("Filip", "Maurice", 29, "Germany"));
        userService.add(new User("Ivan", "Selin", 31, "Hungary"));


        context.close();
    }
}
