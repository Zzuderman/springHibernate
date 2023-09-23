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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("Opel_Insignia"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Nissan_Juke"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("Dodge_RAM"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Ford_Mustang"));



//      userService.addCar(new Car("Opel_Insignia"));
//      userService.addCar(new Car("Nissan_Juke"));
//      userService.addCar(new Car("Dodge_RAM"));
//      userService.addCar(new Car("Ford_Mustang"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar());
      }

      List<User> usersAndCar = userService.listUsersForSeriesAndModelCar("Opel_Insignia",1);
      for (User user : usersAndCar) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getUserCar());
      }

      context.close();
   }
}
