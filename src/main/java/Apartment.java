/**
 *  An Apartment class, subclass of Residence, with its attributes and methods.
 *  @author: George Kazazis, it214124
 */

import java.util.ArrayList;

public class Apartment extends Residence{
    
    private int floor;                                                          //-Apartment's floor.
    private boolean elevator;                                                   //-Has an elevator: True, or else: False.
    private boolean balcony;                                                    //-Has a balcony: True, or else: False.
    
    public Apartment (String municipality, String address, int vatNumber,       //-
        int residCapacity, int bedrooms, boolean webService, boolean tv,        //--
        boolean kitchen, boolean privateParking, String view,                   //---
        double metroDistance,float dailyCost, int floor,                        //----
        boolean elevator, boolean balcony) {                                    //----- Apartment's Constructor.
            super(municipality, address, vatNumber,residCapacity, bedrooms,     //----- With super, it uses the
                webService, tv, kitchen, privateParking, view,                  //----- Residence's constructor.
                metroDistance, dailyCost);                                      //-----
            this.floor = floor;                                                 //----
            this.elevator = elevator;                                           //---                            
            this.balcony = balcony;                                             //--
    }                                                                           //-

    public void setFloor (int floor) {                                          //-
        this.floor = floor;                                                     //--- Floor number setter.
    }                                                                           //-
    
    public int getFloor () {                                                    //-
        return floor;                                                           //--- Floor number getter.
    }                                                                           //-
    
    public void setElevator (boolean elevator) {                                //-
        this.elevator = elevator;                                               //--- Elevator existence setter.
    }                                                                           //-
    
    public String getElevator () {                                              //-
        if (elevator){                                                          //--
            return "Yes";                                                       //--- Elevator existence getter. If the value
        } else {                                                                //--- is "True", it returns "Yes" to make it
            return "No";                                                        //--- more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    public void setBalcony (boolean balcony) {                                  //-
        this.balcony = balcony;                                                 //--- Balcony existence setter.
    }                                                                           //-
    
    public String getBalcony () {                                               //-
        if (balcony) {                                                          //--
            return "Yes";                                                       //--- Balcony existence getter. If the value
        } else {                                                                //--- is "True", it returns "Yes" to make it
            return "No";                                                        //--- more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    //Methods
    @Override
    public String toString (ArrayList<Residence> residenceArray) {              //-
        return  "The apartment at " + getAddress()                              //--
                + " part of "+ getMunicipality() + " municipality "             //---
                + "has the following features: "                                //----
                + "\nFloor: " + getFloor()                                      //-----
                + "\nCapacity for people: " + getResidCapacity()                //------
                + "\nNo. Bedrooms: "+ getBedrooms()                             //-------
                + "\nOwner's VAT number: " + getVatNumber()                     //-------- This method outputs all the useful
                + "\nInternet Connection Services: " + getWebService()          //-------- information about the apartment,
                + "\nThere is a television: " + getTelevision()                 //-------- including its confort level.
                + "\nThere is a kitchen: " + getKitchen()                       //-------
                + "\nThere is a private parking: " + getPrivateParking()        //------
                + "\nElevator access: " + getElevator()                         //-----
                + "\nBalcony access: " + getBalcony()                           //----
                + "\nConfortation Level: " + getConfortLevel()                  //---
                +"\n\nVerification ID: " + getVerificID(residenceArray)+"\n\n"; //--
    }                                                                           //-
    
    @Override
    public String toView (ArrayList residenceArray) {                           //-
        return  "\tApartment\t\t" + getMunicipality() + "\t\t\t" + getAddress() //-- This method is used to show in a table-like
                + "\t" + getDailyCost()+ "\t\t" + getVerificID(residenceArray); //-- output, the info of the apartment so the
    }                                                                           //-- user can select one, by its Verification ID.
}                                                                               //-