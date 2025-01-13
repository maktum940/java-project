public class Address {
    private String road;
    private String house;
    private String city;

    Address(String road, String house, String city) {
        this.road = road;
        this.house = house;
        this.city = city;
    }

    //getter
    public String getRoad() {
        return road;
    }
    public String getHouse() {return house;}
    public String getCity() {
        return city;
    }

    //setter
    public void setHouse(String house) {
        this.house = house;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public void displayAddressInfo() {
        System.out.println("house: " + house);
        System.out.println("Road: " + road);
        System.out.println("City: " + city);
    }
}
