
/**
 * Write a description of class Temps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Temps
{
    // instance variables - replace the example below with your own
    private String monthName;
    private int year;
    private int [] temps;

    /**
     * Constructor for objects of class Temps
     */
    public Temps(String monthName, int year)
    {
        // initialise instance variables
        this.monthName = monthName;
        this.year = year;
    }

    /**
     *a method
     */
    public void setTemps (String tempStr)
    {
        String [] aux = tempStr.split(",");
        temps = new int [aux.length];
        for(int i = 0; i < aux.length; ++i){
            temps[i] = Integer.parseInt(aux [i]);
        }

    }

    public double getAverage(){
        double sum = 0;
        for(int i = 0; i < temps.length; ++i){
            sum = sum + temps[i];
        }
        double average = sum / (temps.length);
        return average;
    }

    public int getHighest(){
        int highest = 0;
        for(int i = 0; i < temps.length; ++i){
            if(temps [i] > highest) highest = temps[i];
        }
        return highest;
    }

    public int getLowest(){
        int lowest = temps[0];
        for(int i = 0; i < temps.length; ++i){
            if(temps [i] < lowest) lowest = temps[i];
        }
        return lowest;
    }

    public String toString(){
        String s = "The average high temperature for " + monthName +
            ", " + year + " was: " + getAverage();
        String a = "The highest temperature for " + monthName +
            ", " + year + " was: " + getHighest();
        String d = "The lowest temperature for " + monthName +
            ", " + year + " was: " + getLowest();
        return s + "\n" + a + "\n" + d;
    }

    public void printTemps(){
        System.out.println("Daily Temperatures");
        for(int i = 0; i < temps.length; ++i){
            System.out.println("Day " + (i+1) + ": " + temps[i] + 
                "º F");
        }
    }

    public static void main (String [] args){
        Temps temperatures = new Temps ("June" , 2004);
        temperatures.setTemps("73,68,74,74,77,81,85,90,85,72,63,74,83,80,81,81,79,79,69,71,69,70,75,70,68,70,73,72,79,76");
        temperatures.printTemps();
        System.out.print(temperatures.toString());
        
    }
}
