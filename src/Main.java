// Developed by Zamir Khan, for Data Structures and Algorithms
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        LinkedList<LinkedList<Flights>> list = new LinkedList<>();
        try {
            PrintStream outStream = new PrintStream(new FileOutputStream("Output.txt"));
            System.setOut(outStream);
            File file1 = new File("FlightInfo.txt");
            FileReader fileRd1 = new FileReader(file1);
            BufferedReader bufferedRd1 = new BufferedReader(fileRd1);

            String line;
            String[] data;
            boolean checker = true;

            while ((line = bufferedRd1.readLine()) != null) {
                if (checker) {
                    checker = false;
                } else {
                    data = line.split("\\|");
                    boolean found = false;
                    for (int i = 0; i < list.size() && !found; i++) {
                        if (list.get(i).getFirst().getCity().equals(data[0])) {
                            list.get(i).add(new Flights(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                            found = true;
                        }
                    }
                    if (!found) {
                        list.add(new LinkedList<>());
                        list.getLast().addFirst(new Flights(data[0], 0, 0));
                        list.getLast().add(new Flights(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                    }
                }
            }

            String source;
            checker = true;
            File file2 = new File("FlightPlan.txt");
            FileReader fileRd2 = new FileReader(file2);
            BufferedReader bufferedRd2 = new BufferedReader(fileRd2);
            while ((line = bufferedRd2.readLine()) != null) {
                if (checker) {
                    checker = false;
                } else {
                    data = line.split("\\|");
                    source = data[0];
                    int index = findElement(list, source);
                    if (index == -1) {
                        System.out.println("Flight: " + data[0] + ", " + data[1]);
                        System.out.println("Sorry, there are no flights available!");
                    } else {
                        ArrayList<Path> paths = new ArrayList<>();
                        LinkedList<Flights> sourceList = list.get(index);
                        for (int i = 1; i < sourceList.size(); i++) {
                            Flights city = sourceList.get(i);
                            Path origin = new Path(sourceList.getFirst(), sourceList.get(i));
                            paths.add(origin);
                            while (((index = findElement(list, city.getCity())) != -1)) {
                                if (list.get(index).getFirst().isFound()) {
                                    break;
                                }
                                LinkedList<Flights> destinationList = list.get(index);
                                list.get(index).getFirst().setFound(true);
                                for (int j = 1; j < destinationList.size(); j++) {
                                    boolean check = destinationList.get(j).getCity().equals(sourceList.getFirst().getCity());
                                    if (!check)
                                        city = destinationList.get(j);
                                    paths.add(new Path(origin, destinationList.get(j)));
                                }
                            }
                        }
                        LinkedList<Path> search = new LinkedList<>();
                        for (int i = 0; i < paths.size(); i++) {
                            if ((paths.get(i).getCities().peek().getCity()).equals(data[1])) {
                                search.add(paths.get(i));
                            }
                        }

                        int pos = 0;
                        double shortest;
                        int count;
                        if (data[2].equals("T")) {
                            System.out.println("Flight: " + data[0] + ", " + data[1] + " (Time)");
                            if (search.size() == 0) {
                                System.out.println("Can't find a path for this Flight!");
                            }
                            count = 0;
                            while (count <= 3 && search.size() > 0) {
                                shortest = 5000.0;
                                if (search.size() == 1) {
                                    search.get(0).print();
                                    break;
                                } else {
                                    for (int i = 0; i < search.size(); i++) {
                                        if ((search.get(i).getTime()) <= shortest) {
                                            pos = i;
                                            shortest = search.get(i).getTime();
                                        }
                                    }
                                    search.get(pos).print();
                                    search.remove(pos);
                                    count++;
                                }
                            }
                        }
                        if (data[2].equals("C")) {
                            System.out.println("Flight: " + data[0] + ", " + data[1] + " (Cost)");
                            if (search.size() == 0) {
                                System.out.println("Can't find a path for this Flight!");
                            }
                            count = 0;
                            while (count <= 3 && search.size() > 0) {
                                shortest = 5000.0;
                                if (search.size() == 1) {
                                    search.get(0).print();
                                    break;
                                } else {
                                    for (int i = 0; i < search.size(); i++) {
                                        if ((search.get(i).getCost()) <= shortest) {
                                            pos = i;
                                            shortest = search.get(i).getCost();
                                        }
                                    }
                                    search.get(pos).print();
                                    search.remove(pos);
                                    count++;
                                }
                            }
                        }
                        System.out.println();
                        resetFoundVar(list);
                    }
                }
            }
        }
        catch(IOException e){System.out.println("failed");}
    }
    public static int findElement(LinkedList<LinkedList<Flights>> list, String city){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getFirst().getCity().equals(city)){
                return i;
            }
        }
        return -1;
    }
    public static void resetFoundVar(LinkedList<LinkedList<Flights>> list){
        for (LinkedList<Flights> Flights : list) {
            for (Flights flightData : Flights) {
                flightData.setFound(false);
            }
        }
    }
}

