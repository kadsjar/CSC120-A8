import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  // Attributes
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  
  /**
 * Creates a new instance of House
 * Dining room is false and resident array is empty 
 * @param name Name of House
 * @param address House address
 * @param nFloors number of floors
 * system out prints the creation of house and it's name
 */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = false;

    System.out.println("You have built a house: 🏠");
    System.out.println("Welcome to " + this.getName());
  }

  /**
   * Checks if house has a dining hall
   * if resident size surpasses 3
   * @return true
   * if resident size is below 3 
   * @return flase
   */
  public boolean hasDiningRoom(){
    if (this.residents.size() >= 3){
      this.hasDiningRoom = true;
      System.out.println(this.getName() + " does have a dining hall");
      return true;
    }
    else {
      System.out.println(this.getName() + " does not have a dining hall");
      this.hasDiningRoom = false;
      return false;
    }
}

  /**
   * Returns the number of residents 
   * @return number of student array list
   */
  public int nResidents(){
    System.out.println(this.getName() + " has " +this.residents.size() + " residents." );
    return this.residents.size();
  }

  /**
   * Adds a student to the House if they are not already on the list
   * @param s The Array list of students to modify
   */
  public void moveIn(Student s){
     if (this.residents.contains(s)) {
        throw new RuntimeException(s + " already moved in"); 
      } 
      else {
        residents.add(s); 
        System.out.println(s.getName() + " has moved in!");
      }
  }

  /**
   * Removed a student from House if they are present on the list
   * @param s The Array list of students to modify
   * @return s the student removed
   * else tells teh student is already gone
   */
  public Student moveOut(Student s){
    if (this.residents.contains(s)) {
      residents.remove(s);
      System.out.println(s.getName() + " has moved out :(");
      return s;  
    }
    else {
      throw new RuntimeException("I guess " + s.getName() + " already moved out ");
    }
  }

  /**
   * Check if a Student is a resident of the House
   * @param s The Array list of students to modify
   * @return true if the list of residents contains Student
   * else prints not a resident
   * @return false
   */
  public boolean isResident(Student s){
     if (this.residents.contains(s)) {
      System.out.println(s.getName() + " is a resident");
      return true;
    }
    else {
      System.out.println(s.getName() + " is not a resident");
      return false;
    }
  }

  public static void main(String[] args) {
    House Emerson = new House("Emerson", "1 Paradise Rd, Northampton MA 01063", 4);

    Student kaday = new Student("Kaday", "991447922", 2026);
    Student gaby = new Student("Gaby", "991348573", 2026);
    Student kate = new Student("Kate", "993211234", 2026);

    Emerson.moveIn(kaday); 
    Emerson.moveIn(gaby); 
    Emerson.moveIn(kate); 

    Emerson.hasDiningRoom();
    Emerson.isResident(kaday);

    Emerson.nResidents();
    
    Emerson.moveOut(kate);
    Emerson.hasDiningRoom();

  }

}
