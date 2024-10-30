public class Tour {
    private String destination;
    private String hotelName;
    private int hotelPrice;
    private int duration;

    //constructor
    public Tour(String destination, int duration, String hotelName, int hotelPrice) {
        this.destination = destination;
        this.duration = duration;
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
    }

    //getter
    public String getDestination() {
        return destination;
    }
    public int getDuration() {return duration;}


    public void displayTourInfo() {
        System.out.println("Destination: " + destination);
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Hotel Price: " + hotelPrice);
        System.out.println("Duration: " + duration);
        System.out.println("Total price: " + hotelPrice*duration);
        System.out.println();
    }
}