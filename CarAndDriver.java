import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarAndDriver {
    
    static Person  userPrompt(){
        // User input to create the Driver
        Scanner input = new Scanner(System.in);
        Person driver = new Person();
        System.out.println("What is your name?");
        driver.setName(input.nextLine());
        System.out.println("Can you drive a stick? Type 'Y' if you can.");
        driver.setStickDriver(input.nextLine().equalsIgnoreCase("Y")?true:false);
        System.out.println("How old are you?");
        driver.setAge(input.nextInt());
        System.out.println("How tall are you in inches?");
        driver.setHeight(input.nextInt());
        input.close();
        return driver;
    }//end userPrompt

    static List<Car> populateCars(){
         //Creates list of available Cars for the driver.
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota","Prius",2015,"red",38,false));
        cars.add(new Car("Niisan", "Cube", 2014, "Black", 42, false));
        cars.add(new Car("Dodge", "Challenger", 2022, "Blue",39,true));
        return cars;
    }//end populateCars
    
    static List<Car> filterManuals(List<Car> cars){ //filters out any manual cars
        List<Car> viableCars = new ArrayList<>();
            for(Car element: cars){
                if(!element.getIsManual())
                    viableCars.add(element);
            }//endfor
            return viableCars;
    }//end filterManuals

    static List<Car> checkHeights(Person driver, List<Car> cars){ //if the User is twice as tall as the headroom, it filters it out of the list
         List<Car> viableCars = new ArrayList<>();
         for(Car element: cars){
            if(element.getHeadroom() > driver.getHeight()/2){
                viableCars.add(element);
            }//endif
         }//endfor
         return viableCars;
    }//end checkHeights
    
    public static void main(String[] args) throws Exception {
        //TODO Print assignment info
        System.out.printf("Java Advanced\nCOP-2805C-86399\nFebruary 1st, 2024\nMolly Von Behren\n\n");

        Person newDriver = userPrompt();//User creates a profile for themselves

        //FUTURE DEVELOPMENT create more prompts that could narrow down a Person's preference
    
        List<Car> availableCars = populateCars();//creates a list of available cars for the User.

        //FUTURE DEVELOPMENT potentially connect to a car database API that will can automatically populate a list of available cars instead of manually entering some cars?
        
        if(!newDriver.getStickDriver()) //if the User cannot use Manual cars, this filters them out
            availableCars = filterManuals(availableCars);
        availableCars = checkHeights(newDriver, availableCars);//checks if the User is too tall for any cars

        int index = (int)(Math.random() * availableCars.size());// picks a random index off the list of available cars
        try {
            System.out.println("");
            System.out.println(newDriver);
            System.out.println(availableCars.get(index));//prints the random index that was previously made
        }catch(Exception e){
            System.out.println("There are no cars available");// if there are no cars in the list, throws this exception
        }//endtry

        //FUTURE DEVELOPMENT maybe allow the user to choose from a list of cars?
        //FUTER DEVELOPMENT Create a proper app environment
        
    }
}
