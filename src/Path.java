import java.util.ArrayList;
import java.util.Stack;

public class Path {
    private Stack<Flights> cities;
    private double cost;
    private int time;

    public Path(Flights source, Flights destination){
        cities = new Stack<Flights> ();
        cities.push(source);
        cities.push(destination);
        cost = destination.getCost();
        time = destination.getTime();
    }
    public Path(Path path, Flights destination){
        Stack<Flights> list = path.getCities();
        cities = (Stack<Flights>)list.clone();
        cities.push(destination);
        cost = path.getCost() + destination.getCost();
        time = path.getTime() + destination.getTime();

    }
    public Stack<Flights> getCities() {
        return cities;
    }
    public void setCities(Stack<Flights> citiesIn) {
        cities = citiesIn;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(int costIn) {
        cost = costIn;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int timeIn) {
        time = timeIn;
    }
    public void print(){
        ArrayList<String> cities = new ArrayList<> ();
        Stack<Flights> list = (Stack<Flights>) this.cities.clone();
        while(!list.isEmpty()){
            cities.add(list.pop().getCity());
        }
        System.out.print("Path: ");
        for (int i = (cities.size()-1); i >=0; i--){
            if (i == 0) {
                System.out.print(cities.get(i));
            }
            else
                System.out.print(cities.get(i) + " -> ");
        }
        System.out.println(". Time: " + getTime() + " Cost: " + getCost() );
    }
}