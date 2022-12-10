/**
 *  Tenant class with its attributes and methods.
 *  @author: George Kazazis, it214124
 */

public class Tenant {

    private int vatNumber;                                                      //-Tenant's VAT number (ΑΦΜ).
    private String firstName;                                                   //-Tenant's first name.
    private String lastName;                                                    //-Tenant's last name.
    private int id;                                                             //-Tenant's id number (6-digit number).
    private String email;                                                       //-Tenant's email address.
    
    public Tenant (int vatNumber, String firstName, String lastName,            //-
        int id, String email) {                                                 //--
            this.vatNumber = vatNumber;                                         //--- 
            this.firstName = firstName;                                         //--- Tenant's
            this.lastName = lastName;                                           //--- Constructor
            this.id = id;                                                       //---
            this.email = email;                                                 //--
    }                                                                           //-
    
    public void setVatNumber (int vatNumber) {                                  //-
        this.vatNumber = vatNumber;                                             //--- VAT number setter.
    }                                                                           //-
    
    public int getVatNumber() {                                                 //-
        return vatNumber;                                                       //--- VAT number getter.
    }                                                                           //-
    
    public void setFirstName (String firstName) {                               //-
        this.firstName = firstName;                                             //--- First name setter.
    }                                                                           //-
    
    public String getFirstName() {                                              //-
        return firstName;                                                       //--- First name getter.
    }                                                                           //-
    
    public void setLastName (String lastName) {                                 //-
        this.lastName = lastName;                                               //--- Last name setter.
    }                                                                           //-
    
    public String getLastName() {                                               //-
        return lastName;                                                        //--- Last name getter.
    }                                                                           //-
        
    public String getFullName() {                                               //-
        return getFirstName() + " " + getLastName();                            //--- Full name getter.
    }                                                                           //-
    
    public void setID (int id) {                                                //-
        this.id = id;                                                           //--- ID setter.
    }                                                                           //-
    
    public int getID() {                                                        //-
        return id;                                                              //--- ID getter.
    }                                                                           //-
    
    public void setEmail (String email) {                                       //-
        this.email = email;                                                     //--- Email setter.
    }                                                                           //-
    
    public String getEmail() {                                                  //-
        return email;                                                           //--- Email getter.
    }                                                                           //-
    
    @Override
    public String toString () {                                                 //-
        return  "Tenant's full name: " + getFullName()                          //--
                + "\n\t\t\t\tVAT Number: " + getVatNumber()                     //--- This method outputs the tenant's
                + "\n\t\t\t\tEmail address: " + getEmail()                      //--- information.
                + "\n\t\t\t\tID number: " + getID();                            //--
    }                                                                           //-
}