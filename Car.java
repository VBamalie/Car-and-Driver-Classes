public class Car {
    private String _make; //Make of Vehicle
    private String _model; //Model of Vehicle
    private int _year; //year it was made
    private String _color; //color of vehicle
    private int _headroom; //headroom in inches
    private boolean _isManual; //whether it is stick shift or an automatic

    
    public String toString() {
        if(_isManual){
        return "You can drive a " +  _make + " " + _model + " "+ _year + " that is " + _color + " and has " + _headroom + " inches of headroom. It has a stick shift";
        } else {
        return "You can drive a " +  _make + " " + _model + " "+ _year + " that is " + _color + " and has " + _headroom + " inches of headroom. It is automatic.";
        }//endif
    }//end toString

    public Car(String make, String model, int year, String color, int headroom, boolean isManual){
        this._make = make;
        this._model = model;
        this._year = year;
        this._color = color;
        this._headroom = headroom;
        this._isManual = isManual;
    } //end Car
    
    //SETTERS//
    public void setMake(String make){
        this._make = make;
    }
    public void setModel(String model){
        this._model = model;
    }
    public void setYear(int year){
        this._year = year;
    }
    public void setColor(String color){
        this._color = color;
    }
    public void setHeadroom(int headroom){
        this._headroom = headroom;
    }
    public void setIsManual(boolean isManual){
        this._isManual = isManual;
    }
    
    //GETTERS//
    
    public String getMake(){
        return _make;
    }
    public String getModel(){
        return _model;
    }
    public int getYear(){
        return _year;
    }
    public String getColor(){
        return _color;
    }
    public int getHeadroom(){
        return _headroom;
    }
    public boolean getIsManual(){
        return _isManual;
    }
}
