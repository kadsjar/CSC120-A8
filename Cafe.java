
/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    //Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructs a new Cafe building and constructs new values for coffee ounces, sugar packets, creams, and cups
     * @param name name of coffee shop
     * @param address address of shop
     * @param nFloors number of floors
     * system prints that we have built a cafe and a welcome message
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 15;
        this.nSugarPackets = 5;
        this.nCreams = 5;
        this.nCups = 7;

        System.out.println("You have built a cafe: ☕");
        System.out.println("Welcome to " + this.getName()+ " Cafe!");
    }

    /**
     * Sells coffee from the Cafe
     * each order of coffee uses one cup automatically and does not run if no cups are available
     * method subtracts the input of coffee, sugar, and creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCups > 0){
            if (this.nCoffeeOunces > size){ 
                this.nCoffeeOunces -= size;
                this.nCups -= 1;
                System.out.println("Here is your " + size + " oz coffee");

                if (this.nSugarPackets > nSugarPackets){
                    this.nSugarPackets -= nSugarPackets;
                    System.out.println("with " + nSugarPackets + " sugar packet(s)");
                }
                else {
                    System.out.println("so sorry don't have enough sugar packets");
                }
                if (this.nCreams > nCreams){
                    this.nCreams -= nCreams;
                    System.out.println("with " + nCreams + " cream(s)");
                }
                else {
                    System.out.println("so sorry don't have enough cream");
                }
            }
            else {
                System.out.println("So sorry don't have enough coffee, we'll need to restock");
            }
        }
        else {
            System.out.println("Sorry, not enough cups, we'll need to restock");
        }    
    }        

    /**
     * restocks coffee to add the amount given (input)
     * @param nCoffeeOunces amount of coffee ounces 
     * @param nSugarPackets amount of sugar packets 
     * @param nCreams amount of cream splashes
     * @param nCups amount of cups
     */
    private void restock (int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * gets the amount of coffee ounces
     * @return number of coffee ounces
     */
    public int getOunces(){
        return this.nCoffeeOunces;
    }

    /**
     * gets the amount of sugar packets
     * @return number of sugar packets
     */
    public int getSugar(){
        return this.nSugarPackets;
    }

    /**
     * gets the amount of cream splashes
     * @return number of cream splashes
     */
    public int getCream(){
        return this.nCreams;
    }

    /**
     * gets the amount of cups
     * @return the number of cups
     */
    public int getCup(){
        return this.nCups;
    }

    /**
     * to system out print a line that tells how much of each thing in the cafe we have
     */
    public void inventory(){
        System.out.println(this.getName() + " Cafe has: " + getOunces() + " oz left, " + getSugar() + " sugar packets left, " + getCream() + " cream splashes left, and " + getCup() + " cups left.");
    }
        
    public static void main(String[] args) {
        Cafe blackcat = new Cafe("Black Cat", "75 Orchard st New York, New York", 1);
        blackcat.sellCoffee(8, 0, 2);
        blackcat.inventory();
        blackcat.sellCoffee(7, 5, 2);

        blackcat.restock(20, 5, 6, 3);
        blackcat.inventory();
    }
    
}