package Willmann;

public class WE57License {

    private String state;
    private String license;

    public WE57License(){

    }

    public WE57License(String state, String license){



    }

    public String getState(){

        return state;
    }

    public String getLicense(){

        return license;
    }

    public void setState(String state){

        if(state.equals("MISSOURI")){
            this.state = "MO";
        }else if(state.equals("KANSAS")){
            this.state = "KS";
        }else{
        this.state = state.toUpperCase();
        }
    }

    public void setLicense(String license){
        
        this.license = license.substring(0,3).toUpperCase() + " " + license.substring(license.length() - 3, license.length()).toUpperCase();
        }
}
