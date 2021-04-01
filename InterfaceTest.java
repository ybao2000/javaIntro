
// interface is group of method signature
interface Log {
  boolean login(String username, String password);
  void logout(String username);
}

interface Lesson {
  boolean takeLesson(String course);
}

class Student implements Log, Lesson {
  private String name;

  Student(String name){
    this.name = name;
  }
  public boolean login(String username, String password) {
    if (username.equals("bobbie") && password.equals("password")){
      System.out.println("Student " + username + " log in successfully");
      return true;
    }
    else{
      System.out.println("Student " + username + " failed to log in");
      return false;
    }
  }

  // not visible to external (outside of class)
  private void showInfo(){
    System.out.println("Hello World from " + name);
  }

  public void logout(String username) {
    System.out.println("Student " + username + " log out successfully");   
    showInfo();
  }

  @Override
  public boolean takeLesson(String course) {
    System.out.println("Student takes " + course);
    return true;
  }
}

class Teacher implements Log, Lesson {
  public boolean login(String username, String password) {
    if (username.equals("frankie") && password.equals("password")){
      System.out.println("Teacher " + username + " log in successfully");
      return true;
    }
    else{
      System.out.println("Teacher " + username + " failed to log in");
      return false;
    }
  }

  public void logout(String username) {
    System.out.println(username + " log out successfully");       
  }

  @Override
  public boolean takeLesson(String course) {
    System.out.println("Teacher gives " + course);
    return true;
  }

}

class InterfaceTest {
  public static void main(String[] args) {
    Student s1 = new Student("bobbie");
    // s1.showInfo();
    s1.logout("sam");
    // Teacher t1 = new Teacher();
    // s1.login("bobbie", "password");
    // t1.login("frankie", "password");
    // Log l1 = new Student();
    // Log l2 = new Teacher();
    // l1.login("bobbie", "password");
    // l2.login("bobbie", "password");
    // Lesson[] logs = new Lesson[2];
    // logs[0] = new Student();
    // logs[1] = new Teacher();
    // // logs[0].login("bobbie", "password");
    // logs[0].takeLesson("Java");
    // // logs[1].login("bobbie", "password");
    // logs[1].takeLesson("Java");
  }
}
