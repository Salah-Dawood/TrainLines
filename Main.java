package TrainLines;

public class Main {
    public static void main(String[] args) {
        MBTA stops = new MBTA();
        stops.stopsBetweenStations("Red", "South Station", "Green", "Kenmore");
    }
}
