public class Tour {
    private String destination;
    private double price;
    private int duration;

    public Tour(String destination, double price, int duration) {
        this.destination = destination;
        this.price = price;
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public void displayTourInfo() {
        System.out.println("Tour to: " + destination);
        System.out.println("Price: $" + price);
        System.out.println("Duration: " + duration + " days");
    }
}
