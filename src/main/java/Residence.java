/**
 *  A Residence class with its attributes and methods.
 *  @author: George Kazazis, it214124
 */

import java.util.ArrayList;
import java.util.Calendar;

public class Residence {
    
    private String municipality;                                                //-Municipality (Δήμος) of the residence.
    private String address;                                                     //-The address of the residence.
    private int vatNumber;                                                      //-The VAT number (ΑΦΜ) of the owner.
    private int residCapacity;                                                  //-How many people can fit in the residence.
    private int bedrooms;                                                       //-How many bedrooms are there, in the residence.
    private boolean webService;                                                 //-Has Internet Connection: True, or else: False.
    private boolean tv;                                                         //-Has a TV: True, or else: False.
    private boolean kitchen;                                                    //-Has a kitchen: True, or else: False.
    private boolean privateParking;                                             //-Has a private parking: True, or else: False.
    private String view;                                                        //-View of the residence (Street/Sea/Mountain).
    private double metroDistance;                                               //-Distance from the closest metro station.
    private float dailyCost;                                                    //-Daily cost of the residence (in €).
    
    public Residence (String municipality, String address, int vatNumber,       //-
            int residCapacity, int bedrooms, boolean webService, boolean tv,    //--
            boolean kitchen, boolean privateParking, String view,               //---
            double metroDistance, float dailyCost) {                            //----
        this.municipality = municipality;                                       //-----
        this.address = address;                                                 //------
        this.vatNumber = vatNumber;                                             //-------
        this.residCapacity = residCapacity;                                     //-------- Residence's 
        this.bedrooms = bedrooms;                                               //-------- Constructor
        this.webService = webService;                                           //-------
        this.tv = tv;                                                           //------
        this.kitchen = kitchen;                                                 //-----
        this.privateParking = privateParking;                                   //----
        this.view = view;                                                       //---
        this.metroDistance = metroDistance;                                     //--
        this.dailyCost = dailyCost;                                             //-
    }
    
    public void setMunicipality (String municipality) {                         //-
        this.municipality = municipality;                                       //--- Municipality setter.
    }                                                                           //-
    
    public String getMunicipality() {                                           //-
        return municipality;                                                    //--- Municipality getter.
    }                                                                           //-
    
    public void setAddress (String address) {                                   //-
        this.address = address;                                                 //--- Address setter.
    }                                                                           //-
    
    public String getAddress() {                                                //-
        return address;                                                         //--- Address getter.
    }                                                                           //-
    
    public void setVatNumber (int vatNumber) {                                  //-
        this.vatNumber = vatNumber;                                             //--- VAT number setter.
    }                                                                           //-
    
    public int getVatNumber() {                                                 //-
        return vatNumber;                                                       //--- VAT number getter.    
    }                                                                           //-
    
    public void setResidCapacity (int residCapacity) {                          //-
        this.residCapacity = residCapacity;                                     //--- Residence capacity setter.
    }                                                                           //-
    
    public int getResidCapacity() {                                             //-
        return residCapacity;                                                   //--- Residence capacity getter.
    }                                                                           //-
    
    public void setBedrooms (int bedrooms) {                                    //-
        this.bedrooms = bedrooms;                                               //--- "number of bedrooms" setter.
    }                                                                           //-
    
    public int getBedrooms() {                                                  //-
        return bedrooms;                                                        //--- "number of bedrooms" getter.
    }                                                                           //-
    
    public void setWebService (boolean webService) {                            //-
        this.webService = webService;                                           //--- Web service existence setter.
    }                                                                           //-
    
    public String getWebService() {                                             //-
        if (webService) {                                                       //--
            return "Yes";                                                       //--- Web service getter. If the value is 
        } else {                                                                //--- "True", it returns "Yes" to make it
            return "No";                                                        //--- more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    public void setTelevision (boolean tv) {                                    //-
        this.tv = tv;                                                           //--- Television existence setter.
    }                                                                           //-
    
    public String getTelevision() {                                             //-
        if (tv) {                                                               //--
            return "Yes";                                                       //--- Television existence getter. If the value
        } else {                                                                //--- is "True", it returns "Yes" to make it
            return "No";                                                        //--- more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    public void setKitchen (boolean kitchen) {                                  //-
        this.kitchen = kitchen;                                                 //--- Kitchen existence setter.
    }                                                                           //-
    
    public String getKitchen() {                                                //-
        if (kitchen) {                                                          //--
            return "Yes";                                                       //--- Kitchen existence getter. If the value
        } else {                                                                //--- is "True", it returns "Yes" to make it
            return "No";                                                        //--- more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    public void setPrivateParking (boolean privateParking) {                    //-
        this.privateParking = privateParking;                                   //--- Private parking existence setter.
    }                                                                           //-
    
    public String getPrivateParking() {                                         //-
        if (privateParking) {                                                   //--
            return "Yes";                                                       //--- Private parking existence getter. If the
        } else {                                                                //--- value is "True", it returns "Yes" to make
            return "No";                                                        //--- it more presentative, or else "No".
        }                                                                       //--
    }                                                                           //-
    
    public void setView (String view) {                                         //-
        this.view = view;                                                       //--- View setter.
    }                                                                           //-
    
    public String getView() {                                                   //-
        return view;                                                            //--- View getter.
    }                                                                           //-
    
    public void setMetroDistance (float metroDistance) {                        //-
        this.metroDistance = metroDistance;                                     //--- Metro distance getter.
    }                                                                           //-
    
    public double getMetroDistance() {                                          //-
        return metroDistance;                                                   //--- Metro distance setter.
    }                                                                           //-
    
    public void setDailyCost (float dailyCost) {                                //-
        this.dailyCost = dailyCost;                                             //--- Daily cost setter.
    }                                                                           //-
    
    public float getDailyCost() {                                               //-
        return dailyCost;                                                       //--- Daily cost getter.
    }                                                                           //-
    
    public double getConfortLevel() {                                           //- Making the confort level by dividing
        return getResidCapacity()/getBedrooms();                                //  the capacity of the residence with 
    }                                                                           //  the number of the bedrooms, it has.
    
    String count1;
    public String getVerificID(ArrayList <Residence> residenceArray) {                 //- Making the Verification ID by getting
        if (residenceArray.size() < 10) {                                              //  the first 2 chars in upper case, then 
            count1 = String.format("%04d", residenceArray.indexOf(this)+1);            //  "-" and finally adding the index of
        } else if ((residenceArray.size() >= 10) && (residenceArray.size() < 100)){    //  the element of the residenceArray,
            count1 = String.format("%03d", residenceArray.indexOf(this)+1);            //  so that in every residence being
        } else if ((residenceArray.size() >= 100) && (residenceArray.size() < 1000)){  //  added, the Verification ID will be
            count1 = String.format("%02d", residenceArray.indexOf(this)+1);            //  increased by one.
        } else if ((residenceArray.size() >= 1000) && (residenceArray.size() < 10000)){//  The use of the String.format and the
            count1 = String.format("%01d", residenceArray.indexOf(this)+1);            //  "%0*d" (where * is a number)is to make
        }                                                                              //  it look like "0001" instead of "1"
        return getMunicipality().substring(0, 2).toUpperCase() +                       //  so that we get the requested form
        "-" + count1;                                                                  //  of "XX-AAAA" , where "XX" is the
    }                                                                                  //  first two letter of the municipality.
    
    public String toView (ArrayList residenceArray) {                                  //- This method is to output 
        return  "Residence at " + getAddress() + ", part of " + getMunicipality()      //  some useful info about a 
                +" municipality, has a Verification Number of "                        //  residence, address,
                + getVerificID(residenceArray) +"\nand the cost to rent is "           //  municipality, Verification
                + getDailyCost() + "/day.\n\n";                                        //  ID, and daily cost.
    }
    
    String count;
    public String getReservationCode(Calendar resBeginDate, ArrayList <Reservation> reservationArray) { //- Making the Reservation code
        if (reservationArray.size() < 10) {                                                  //  the same way we made the     
            count = String.format("%05d", reservationArray.size()+1);                        //  Verification ID, but the
        } else if ((reservationArray.size() >= 10) && (reservationArray.size() < 100)){      //  number will appear in the form   
            count = String.format("%04d", reservationArray.size()+1);                        //  of "00001" and the whole 
        } else if ((reservationArray.size() >= 100) && (reservationArray.size() < 1000)){    //  code will be appearing in 
            count = String.format("%03d", reservationArray.size()+1);                        //  the requested form of
        } else if ((reservationArray.size() >= 1000) && (reservationArray.size() < 10000)){  //  "XX-ΕΤΟΣ-AAAAA", where "XX"
            count = String.format("%02d", reservationArray.size()+1);                        //  is again the first two letters
        } else if ((reservationArray.size() >= 10000) && (reservationArray.size() < 100000)){//  of the municipality, "ΕΤΟΣ"
            count = String.format("%01d", reservationArray.size()+1);                        //  is the year in which the
        }                                                                                    //  reservation has been made, and
        return getMunicipality().substring(0, 2).toUpperCase() +                             //  "AAAAA" are an increasing 
                "-" + resBeginDate.get(Calendar.YEAR) + "-" +                                //  number, according to any 
                count;                                                                       //  reservation being added
    }                                                                                        //  to reservationArray.
    
    public String toString(ArrayList<Residence> residenceArray) {               // This method was added, so that the subclass'     
        throw new UnsupportedOperationException("Not supported yet.");          // method can be used by overriding it.
    }                                                                           
}