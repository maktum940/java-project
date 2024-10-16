public class Tour {
    private String destination;
    private double price;
    private int duration;

    //constructor
    public Tour(String destination, double price, int duration) {
        this.destination = destination;
        this.price = price;
        this.duration = duration;
    }

    //getter
    public String getDestination() {
        return destination;
    }
    public double getPrice() {
        return price;
    }
    public int getDuration() {return duration;}

    //display
    public void displayTourInfo() {
        System.out.println("Tour to: " + destination);
        System.out.println("Price: $" + price);
        System.out.println("Duration: " + duration + " days");
    }
}
