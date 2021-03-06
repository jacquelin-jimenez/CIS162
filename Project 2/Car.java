import java.text.DecimalFormat;
import java.util.Random;
/**
 * Class Car will determine milage, oil changes and other features based on make and model of car.
 *
 * @author (Jacquelin)
 * @version (2/17/2020)
 */
public class Car
{
    // instance variables for Car
    private String Make;
    private String Model;
    private int Year;
    private double Odometer;
    private double MileageNextOilChange;
    private double GallonsInTank;
    private double MilesPerGallon;
    boolean isEngineOn;
    
    
    private static final double TANK_CAPACITY = 12.50;
    
    private static final int MILES_BETWEEN_OIL_CHANGE = 5000;
    
    private static DecimalFormat df = new DecimalFormat ("###,##0.00 ");
    
    

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
       Make = "Ford";
       Model = "Explorer";
       Year = 2020;
       MilesPerGallon = 29.0;
       GallonsInTank = 12.50;
       Odometer = 0.0;
       MileageNextOilChange = 5000;   
    }
    public Car (String make, String model, int y, double mpg)
    {
       Make = make;
       Model = model;
       Year = y;
       MilesPerGallon = mpg;
       GallonsInTank = 12.50;
       Odometer = 0.0;
       MileageNextOilChange = 5000; 
       
    }
    public String getMake(){
        return Make;
    }
    public String getModel(){
        return Model;
    }
    public double getMpg(){
        return MilesPerGallon;
    }
    public int getYear (){
        return Year;
    }
    public double getMileageNextOilChange(){
        return MileageNextOilChange;
    }
    public double checkOdometer(){
        df.format(Odometer);
        return Odometer;
    }
    public double checkGasGauge(){
        df.format(GallonsInTank);
        return GallonsInTank;
    }
    //mutator methods
    
    public void setMake(String make){
        Make = make;
    }
    public void setModel (String model){
        Model = model;
    }
    public void setMpg(double value){
        MilesPerGallon  = value;
    }
    public void setYear (int y){
        Year = y;
    }
    public void honkHorn (){
        System.out.println("beeeeeeeeeeep!");
    }
    public void addGas (double gallons){
    if(isEngineOn == false){    
    if(gallons < 0){
         System.out.print(Make + " " + Model + " " + Year);
         System.out.print(" gallons cannot be a negative number");
         System.out.print(" - Gas in Tank after the fill up: ");
         System.out.println(GallonsInTank);
    }
    else if(gallons + GallonsInTank > TANK_CAPACITY){
        GallonsInTank = (gallons + GallonsInTank);
        double extra = Math.abs(GallonsInTank - TANK_CAPACITY);
        GallonsInTank -= extra;
        System.out.print(Make + " " + Model + " " + Year);
        System.out.print(" tank overflowed");
        System.out.print(" - Gas in Tank after the fill up: ");
        System.out.println(GallonsInTank);
    }
    else{
       GallonsInTank = gallons + GallonsInTank;
        System.out.print(Make + " " + Model + " " + Year);
        System.out.print(" added gas: " + gallons);
        System.out.print(" - Gas in Tank after the fill up: ");
        System.out.println(GallonsInTank); 
    }
    }
    else{
        System.out.print(Make + " " + Model + " " + Year
        + " must be OFF to add gas.");
    }
    }
    public void drive (double miles){
    double TotalMiles = GallonsInTank * MilesPerGallon;
    if(isEngineOn == true){
    if(miles < 0){
       System.out.print(Make + " " + Model + " " + Year);
       System.out.println(" cannot drive negative miles.");
    }
    else if(miles > TotalMiles){
        Odometer += miles; 
        double extra = Math.abs(Odometer - TotalMiles);
        Odometer -= extra;
        GallonsInTank = 0.0;
        System.out.print(Make + " " + Model + " " + Year);
        System.out.println(" ran out of gas after driving " + Odometer + " miles.");
        isEngineOn = false;
    }
    else{
        Odometer += miles;
        GallonsInTank = Math.abs((1/MilesPerGallon) * miles - GallonsInTank);
        System.out.print(Make + " " + Model + " " + Year);
        System.out.print(" drove " + miles + " miles.");
    }
    }
    else{
        System.out.print(Make + " " + Model + " " + Year
        + " must be ON to drive.");
    }
    }

    public void changeOil(){
      if(isEngineOn == false){  
        MileageNextOilChange = Odometer + MILES_BETWEEN_OIL_CHANGE;
        System.out.print(Make + " " + Model + " " + Year);
        System.out.print(" oil changed, next mileage to change oil is: ");
        System.out.println(MileageNextOilChange);
    }
    else{
        System.out.print(Make + " " + Model + " " + Year
        + " must be OFF to change oil.");
    }
    }
    
    public void checkOil(){
    MileageNextOilChange = Odometer + MILES_BETWEEN_OIL_CHANGE;  
    if(isEngineOn == false){
        if(Odometer == MileageNextOilChange){    
         System.out.print(Make + " " + Model + " " + Year);
         System.out.println(" - It is time to change the oil.");
    } 
    else{
        System.out.print(Make + " " + Model + " " + Year);
        System.out.println(" - Oil is OK, no need to change.");
    }
    }
    else{
        System.out.print(Make + " " + Model + " " + Year
        + " must be OFF to check oil.");
    }
    }
    
    public String toString (){
        return Make + " " + Model + " " + Year
            + " Odometer: " + df.format(Odometer) + 
            " Gas in Tank: " + df.format(GallonsInTank) ;
    }
    public boolean equals (Car other){
        boolean isEqual = false;
     if(other.getMake().equals(Make) && 
            other.getModel().equals(Model) && 
                other.getYear() == (Year)){
                    isEqual = true;
     }
    return isEqual;
    }
    public void startEngine(){
        isEngineOn = true;
        System.out.println(Make + " " + Model + " " + Year
        + " - engine started.");
    }
    public void stopEngine(){
        isEngineOn = false;
        System.out.println(Make + " " + Model + " " + Year
        + " -engine stopped.");
    }
    public boolean isEngineOn(){
        if(isEngineOn == true){
            return true;
        }
        else{
            return false;
        }
    }
    private double calcRange(){
        double totalRange = MilesPerGallon * GallonsInTank;
        return totalRange;
    }
    private double calcGasNeededToFillTank(){
        double fill = TANK_CAPACITY - GallonsInTank;
        return fill;
    }
    public void simulateMultiCityTrip(int numberCities){
        Random rand = new Random();
        while(numberCities > 0){
            calcRange();
            int milesNextCity = rand.nextInt((int)calcRange()) +1;
            startEngine();
            drive(milesNextCity);
            stopEngine();
            calcGasNeededToFillTank();
            addGas(calcGasNeededToFillTank());
            numberCities --;
            
        }
       System.out.println("You have arrived");
        }
}
