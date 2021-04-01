// we defined a Person class
class User {
  // what can be inside the class?
  // property -- variable inside class
  String _firstName;  // static property
  String _lastName;
  String _email;
  int _age;
  int _grade;

  User(String firstName, String lastName){
    _firstName = firstName;
    _lastName = lastName;   
  }

  // constructor is called everytime you make the instance
  User(String firstName, String lastName, String email, int age, int grade){
    _firstName = firstName;
    _lastName = lastName;
    _email = email;
    _age = age;
    _grade = grade;
  }

  // method -- function inside class
  static boolean login(String username, String password){
    if (username.equals("bobbie") && password.equals("password")){
      System.out.println(username + " log in successfully");
      return true;
    }
    else{
      System.out.println(username + " failed to log in");
      return false;
    }
  }

  void logout(String username){
    System.out.println(username + " log out successfully");
  }

  void HelloWorld() {
    System.out.println("Hello world");
  }

  void showInfo(){
    System.out.printf("My first name is %s and my last name is %s\n", _firstName, _lastName);
    HelloWorld();
  }
}

public class ClassTest {
  public static void main(String[] args) {
    User user1 = new User("Bobbie", "King", "fancy@email.com", 8, 3);  // I just created an instance of type of User
    User user2 = new User("Amy", "Smith");
    // String username = new String("bobbie");
    // String password = new String("password");
    // user1.login(username, password);
    User.login("bobbie", "password");
    user1.logout("bobbie");
    // user1._firstName = "bobbie";
    // user1._lastName = "King";
    user1.showInfo();
    user2.showInfo();
  }
}
