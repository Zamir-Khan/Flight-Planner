public class Flights {
    private String city;
    private double cost;
    private int time;
    boolean found;

    public Flights(String cityIn, double costIn, int timeIn){
        city = cityIn;
        cost = costIn;
        time = timeIn;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String cityIn) {
        city = cityIn;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double costIn) {
        cost = costIn;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int timeIn) {
        time = timeIn;
    }
    public boolean isFound() {
        return found;
    }
    public void setFound(boolean foundIn) {
        found = foundIn;
    }
}