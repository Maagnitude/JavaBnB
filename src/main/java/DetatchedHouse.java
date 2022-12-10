/**
 *  A Detatched House Class, subclass of Residence, with its attributes and methods
 *  @author: George Kazazis, it214124
 */

import java.util.ArrayList;

public class DetatchedHouse extends Residence{
    
    private double gardenSize;                                                  //-Garden size (m^2). If there isn't one: 0.0
    private double sPoolSize;                                                   //-Swimming pool (m^2). If the isn't one: 0.0
    private boolean barbeque;                                                   //-Has a barbeque: True, or else: False.
    
    public DetatchedHouse (String municipality, String address, int vatNumber,  //-
        int residCapacity, int bedrooms, boolean webService, boolean tv,        //--
        boolean kitchen, boolean privateParking, String view,                   //---
        double metroDistance, float dailyCost, double gardenSize,               //----
        double sPoolSize, boolean barbeque) {                                   //----- Detatched Houses's Constructor.
            super(municipality, address, vatNumber,residCapacity, bedrooms,     //----- With super, it uses the 
                webService, tv, kitchen, privateParking, view,                  //----- Residence's constructor.
                metroDistance, dailyCost);                                      //-----
            this.gardenSize = gardenSize;                                       //----
            this.sPoolSize = sPoolSize;                                         //---
            this.barbeque = barbeque;                                           //--
        }                                                                       //-
    
    public void setGardenSize (float gardenSize) {                              //-
        this.gardenSize = gardenSize;                                           //--- Garden size setter.
    }                                                                           //-
    
    public double getGardenSize () {                                            //-
        return gardenSize;                                                      //--- Garden size getter.
    }                                                                           //-
    
    public void setSPoolSize (float sPoolSize) {                                //-
        this.sPoolSize = sPoolSize;                                             //--- Swimming pool size setter.
    }                                                                           //-
    
    public double getSPoolSize () {                                             //-
        return sPoolSize;                                                       //--- Swimming pool size getter.
    }                                                                           //-
    
    public void setBarbeque (boolean barbeque) {                                //-
        this.barbeque = barbeque;                                               //--- Barbeque existence setter.
    }                                                                           //-
    
    public String getBarbeque () {                                              //-
        if (barbeque) {                                                         //--
            return "Yes";                                                       //--- Barbeque existence getter. If the value
        } else {                                                                //--- is "True", it returns "Yes" to make it
            return "No";                                                        //--- more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    @Override
    public String toString (ArrayList<Residence> residenceArray) {              //-
        return  "The detatched house at " + getAddress()                        //--
                + " part of "+ getMunicipality() + " municipality "             //---
                + "has the following features: "                                //----
                + "\nGarden size: " + getGardenSize()                           //-----
                + "\nCapacity for people: " + getResidCapacity()                //------
                + "\nNo. Bedrooms: " + getBedrooms()                            //-------
                + "\nOwner's VAT number: " + getVatNumber()                     //-------- This method outputs all the useful
                + "\nInternet Connection Services: " + getWebService()          //-------- information, about the detatched
                + "\nThere is a television: " + getTelevision()                 //-------- house, including its confort level.
                + "\nThere is a kitchen: " + getKitchen()                       //-------
                + "\nThere is a private parking: " + getPrivateParking()        //------
                + "\nSwimming Pool: " + getSPoolSize()                          //-----
                + "\nBarbeque: " + getBarbeque() + "\n\n"                       //----
                + "Confortation Level: " + getConfortLevel()                    //---
                +"\n\nVerification ID: " + getVerificID(residenceArray)+"\n\n"; //--
    }                                                                           //-
    
    @Override
    public String toView (ArrayList residenceArray) {                           //-         
        return  "\tDetatched house\t\t" + getMunicipality() + "\t\t\t"          //-- This method is used to show in a table-like
                + getAddress() +"\t" + getDailyCost()+ "\t\t"                   //-- output, the info of the detatched house
                + getVerificID(residenceArray);                                 //-- so the user can select one by its verif. ID.
    }                                                                           //-
}