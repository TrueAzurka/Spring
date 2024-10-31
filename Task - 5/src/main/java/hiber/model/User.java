package hiber.model;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @Column(name = "age")
   private String age;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "cars_id", referencedColumnName = "id")
   private Car car;

   public User() {}

   public User(String name, String lastName, String email, String age, Car car) {
      this.name = name;
      this.lastName = lastName;
      this.email = email;
      this.age = age;
      this.car = car;
   }

   public Long getId() {
      return id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAge() {
      return age;
   }

   public void setAge(String age) {
      this.age = age;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }


   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", age='" + age + '\'' +
              ", car=" + car +
              '}';
   }
}
