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
        driver.setAge(Integer.parseInt(input.nextLine()));
        System.out.println("How tall are you in inches?");
        driver.setHeight(Integer.parseInt(input.nextLine()));
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
            if(viableCars.isEmpty()){
                System.out.println("All the cars left are manual!");
            }//endif
            return viableCars;
    }//end filterManuals

    static List<Car> checkHeights(Person driver, List<Car> cars){ //if the User is twice as tall as the headroom, it filters it out of the list
         List<Car> viableCars = new ArrayList<>();
         for(Car element: cars){
            if(element.getHeadroom() > driver.getHeight()/2){
                viableCars.add(element);
            }//endif
            else{
                System.out.println("Your too tall!");
            }//endelse
         }//endfor
         return viableCars;
    }//end checkHeights

    static List<Car> connectUsersToCars(List<Car> availableCars){
        Person newDriver = userPrompt();//User creates a profile for themselves
        if(!newDriver.getStickDriver()) //if the User cannot use Manual cars, this filters them out
            availableCars = filterManuals(availableCars);
        availableCars = checkHeights(newDriver, availableCars);//checks if the User is too tall for any cars

        int index = (int)(Math.random() * availableCars.size());// picks a random index off the list of available cars
        try {
            availableCars.get(index).setDriver(newDriver);//sets the new driver for this car
            System.out.println("");
            System.out.println(availableCars.get(index).getDriver()); //prints out the info of the car's new driver
            System.out.println(availableCars.get(index));//prints out the information of the car
            System.out.println("");
            availableCars.remove(index); //removes the car from the list of available cars
            return availableCars;
        }catch(Exception e){
            System.out.println("There are no cars available for you, Sorry");
            return availableCars;// if there are no cars in the list, throws this exception
        }//endtry
    }//end connectUsersToDrivers
    
    public static void main(String[] args) throws Exception {
        System.out.printf("Java Advanced\nCOP-2805C-86399\nFebruary 1st, 2024\nMolly Von Behren\n\n");

        //FUTURE DEVELOPMENT create more prompts that could narrow down a Person's preference
    
        List<Car> availableCars = populateCars();//creates a list of available cars for the User.
        
        availableCars = connectUsersToCars(availableCars);
        availableCars = connectUsersToCars(availableCars);
        availableCars = connectUsersToCars(availableCars);
        if(!availableCars.isEmpty()){
            System.out.println("Here are the cars that are still avaiable for purchase: ");
            for (Car car : availableCars) {
                System.out.println(car);
            }//endfor
        }//endif

        //FUTURE DEVELOPMENT potentially connect to a car database API that will can automatically populate a list of available cars instead of manually entering some cars?

        //FUTURE DEVELOPMENT maybe allow the user to choose from a list of cars?
        //FUTERE DEVELOPMENT Create a proper app environment
    }
}

