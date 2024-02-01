public class Person {
    private String _name; //Name of person
    private int _age; //age  in years
    private int _height; //in inches
    private boolean _stickDriver; //whether the driver and drive a manual transistor

    Person(){
    }
    //SETTERS//
    public void setName(String name){
        this._name = name;
    }
    public void setAge( int age){
        this._age = age;
    }
    public void setHeight( int height){
        this._height = height;
    }
    public void setStickDriver(boolean stickDriver){
        this._stickDriver = stickDriver;
    }

    //GETTERS//

    public String getName(){
        return _name;
    }
    public int getAge(){
        return _age;
    }
    public int getHeight(){
        return _height;
    }
    public boolean getStickDriver(){
        return _stickDriver;
    }


    
    public String toString() {
        if(_stickDriver){
            return "You are named "+ _name + ". You are " + _age + " years old and " + _height + " inches tall. You can drive a stick.";
        }else{
            return "You are named "+ _name + ". You are " + _age + " years old and " + _height + " inches tall. You cannot drive a stick.";
        }
    }
}
