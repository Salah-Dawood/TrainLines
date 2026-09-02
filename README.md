#Content of MBTA.java

package TrainLines;

import java.util.Arrays;

public class MBTA {
    private String sLine;
    private String sStation;
    private String eLine;
    private String eStation;
    private String lines[] = {"Red","Green","Orange"};
    private String Red[] = {"South Station", "Park Street","Kendall", "Central", "Harvard", "Porter", "Davis", "Alewife"};
    private String Green[] = {"Government Center", "Park Street", "Boylston", "Arlington", "Copley", "Hynes", "Kenmore"};
    private String Orange[] = {"North Station", "Haymarket", "Park Street", "State", "Downtown Crossing", "Chinatown", "Back Bay", "Forest Hills"};
    private int stops;
    private String cLine;
    private String cStation;

    public void stopsBetweenStations(String sLine, String sStation, String eLine, String eStation) {
        this.sLine = sLine;
        this.sStation = sStation;
        this.eLine = eLine;
        this.eStation = eStation;
        this.stops = 0;
        this.cStation = this.sStation;
        System.out.println("You are at " + this.sStation + " Station on the " + this.sLine + " line");
        System.out.println("Your destination is " + this.eStation + " on the " + this.eLine + " line");
        if (!this.sLine.equals(this.eLine)){
            System.out.println("destination is not in same line");
            System.out.println("Going to Park Street station to change line");
            goToPark(getLineStops(this.sLine), this.sStation);
            this.cStation = "Park Street";
        }
        System.out.println("going to " + this.eStation + " on line " + this.eLine);
        this.stops = getWrap(getLineStops(this.eLine).length,Arrays.asList(getLineStops(this.eLine)).indexOf("Park Street"),Arrays.asList(getLineStops(this.eLine)).indexOf(this.eStation),this.stops);
        System.out.println("Total stops: " + this.stops);
    }

    public String[] getLineStops(String line){
        if (line.equals("Red")){
            return Red;
        } else if (line.equals("Green")) {
            return Green;
        } else {
            return Orange;
        }
    }

    public void goToPark(String[] line, String station){
        int dest = Arrays.asList(line).indexOf("Park Street");
        int src = Arrays.asList(line).indexOf(station);
        this.stops = getWrap(line.length,src,dest,this.stops);
        System.out.println("reached Park Street Station with "+ this.stops +" stop/s");
    }

    public int getWrap(int lineLength,int src, int dst,int stops){
        while (src != dst) {
            src = (src + 1) % lineLength;
            stops++;
        }
        return stops;
    }

    public void lineStop(String line,String start, String stop){

    }
}
