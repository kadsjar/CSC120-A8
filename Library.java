import java.util.Hashtable;
import java.util.Map;

/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements {

  /**
   * Added attribute
   * A hashtable that maps book titles to their availability status.
   * True means the book is available; false means it is checked out.
   */
  private Hashtable<String, Boolean> collection;

    /**
     * Constructor for Library, calls on super and constructs new Hastable
     * @param name Name of Library
     * @param address address of library
     * @param nFloors number of floors
     * system prints out that the library has been printed and a welcome message
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable <String, Boolean>();

      System.out.println("You have built a library: 📖");
      System.out.println("Welcome to " + this.getName());
    }

    /**
     * Adds new books to the collection
     * the book is automaticaly marked available
     * @param title the name of the title and author to be added
     */
    public void addTitle(String title){
      //libraries can have more tha one copy so, will allow duplicates
      this.collection.put(title, true);
      System.out.println(title + " has been added.");
    }

    /**
     * Removes a book that is already in collection
     * @param title the name of the title and author to be removed
     * @return the title that was removed
     * Other wise prints that the title can't be removed because not in system
     */
    public String removeTitle (String title){
      if (this.collection.containsKey(title)) {
        this.collection.remove(title);
        System.out.println(title + " has been removed.");
        return title;
      }
      else{
        System.out.println("Cannot remove " + title + ". Not in collection");
        return null;
      }
    }

    /**
     * Checks out a book from the collection
     * changes the boolean in hastable from true to false
     * @param title the name of the title and author to be checked out
     * if book is already check out (boolean=flase) will print it is already checked out
     * otherwise prints that the book is not in the collection
     */
    public void checkOut(String title){
      if (this.collection.containsKey(title)) {
        if (this.collection.get(title)){
          this.collection.put(title, false);
          System.out.println(title + " is now checked out.");
        }
        else {
          System.out.println(title + " is already checked out.");
        }
      } 
      else {
        System.out.println("We do not have " + title + " in our collection.");
      }
    }

    /**
     * Returns a book that has been previously checked out
     * if boolean=false it is changed to true
     * @param title the name and author of the book to be returned
     * if the boolean=true will tell user the book is not checked out
     * otherwise we do not have the book in collection
     */
    public void returnBook(String title){
      if (this.collection.containsKey(title)) {
        if (!this.collection.get(title)){
          this.collection.put(title, true);
          System.out.println("Thank You for returning " + title + ".");
        }
        else {
        System.out.println("Don't think you checked that one out, did you want to?");
        }
      }
      else {
        System.out.println("We do not have " + title + " in our collection.");
      }
    }

    /**
     * checks the system to if the collection contains a book
     * @param title the title and author to check
     * @return true if the book is in collection - will print message
     * @return false if book is not in collection - will print message
     */
    public boolean containsTitle (String title){
       if (this.collection.containsKey(title)){
        System.out.println("We do have " + title + " in our collection.");
        return true;
       }
       else {
        System.out.println("We do not have " + title + " in our collection.");
        return false;
       }
    }

    /**
     * checks the system to see if book is available to be checked out if boolean = true
     * @param title name and author of book to check
     * @return true if book is available
     * @return false if book is not avaible or if book is not in system - will print message for each case
     */
    public boolean isAvailable(String title){
      if (this.collection.containsKey(title)) {
        if (this.collection.get(title)) {  // checks if this specific title is true
            System.out.println(title + " is available");
            return true;
        } else {
            System.out.println(title + " is not available");
            return false;
        }
    } else {
        System.out.println("We do not have " + title + " in our collection.");
        return false;
    }
}

    /**
     * Prints out the collection of books in library system along with avaiblility
     * contains a for loop 
     */
    public void printCollection(){
      System.out.println();
      System.out.println("***********************************");
      System.out.println(this.getName() + "'s Collection: ");
      System.out.println("***********************************");
      for (Map.Entry<String, Boolean> entry : this.collection.entrySet()) {
        System.out.println("Title: " + entry.getKey() + ", Availble: " + entry.getValue());
      }
      System.out.println("***********************************");
    }
  

  
    public static void main(String[] args) {
      Library josten = new Library("Josten Library", "1 Chapin Way Northampton MA 01063", 3);
      josten.addTitle("On Earth We're Briefly Gorgeous by Ocean Vuong");
      josten.addTitle("Pride and Predjudice by Jane Austen");
      josten.addTitle("The Book of Mormon by Joseph Smith");

      josten.checkOut("Pride and Predjudice by Jane Austen");

      josten.containsTitle("Pride and Predjudice by Jane Austen");
      josten.isAvailable("Pride and Predjudice by Jane Austen");

      josten.checkOut("Pride and Predjudice by Jane Austen");

      josten.isAvailable("The Art of War by Sun Tzu");
      josten.returnBook("The Book of Mormon by Joseph Smith");
      josten.printCollection();

      System.out.println(josten.toString());
    }
  
  }