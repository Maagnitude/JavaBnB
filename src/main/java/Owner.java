/**
 *  An Owner class with its attributes and methods.
 *  @author: George Kazazis, it214124
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Owner {

    private int vatNumber;                                                      //-Owner's VAT number (ΑΦΜ).
    private String firstName;                                                   //-Owner's first name.
    private String lastName;                                                    //-Owner's last name.
    private String address;                                                     //-Owner's home address.
    private int id;                                                             //-Owner's id number (a 6-digit number).
    
    Scanner input = new Scanner(System.in);                                     //-Making Scanner object for user input.
    Backup backup = new Backup();                                               //-Making Backup object for its useful methods.
    
    public Owner (int vatNumber, String firstName, String lastName,             //-
        String address, int id) {                                               //--
            this.vatNumber = vatNumber;                                         //---
            this.firstName = firstName;                                         //---- Owner's
            this.lastName = lastName;                                           //---- Constructor
            this.address = address;                                             //---
            this.id = id;                                                       //--
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
    
    public void setAddress (String address) {                                   //-
        this.address = address;                                                 //--- Address setter.
    }                                                                           //-
    
    public String getAddress() {                                                //-
        return address;                                                         //--- Address getter.
    }                                                                           //-
    
    public void setID (int id) {                                                //-
        this.id = id;                                                           //--- ID setter.
    }                                                                           //-
    
    public int getID() {                                                        //-
        return id;                                                              //--- ID getter.
    }                                                                           //-
    
    @Override
    public String toString () {                                                 //-                          
        return  "Owner's full name: " + getFullName()                           //--
                + "\n\t\t\t\tVAT Number: " + getVatNumber()                     //--- This method outputs the owner's info
                + "\n\t\t\t\tHome address: " + getAddress()                     //---
                + "\n\t\t\t\tID number: " + getID();                            //--
    }                                                                           //-
    
    public void registerApartment(ArrayList <Residence> residenceArray,         //- This method register a new apartment.
            ArrayList <Owner> ownerArray,                                       //
            ArrayList <Reservation> reservationArray, int vat) {                //
        String municipality, address1, view;
        int capacity, bedrooms, floor;
        boolean webS, tvS, kitchenS, parkingS, elevS, balconS;
        double Mdistance;
        float cost;
        do {
            try {
                System.out.println("Enter your apartment by giving the  "       //
                        + "following info:\nMunicipality: ");                   //
                municipality = input.next();                                    // Inputs apartment's municipality.
                System.out.println("Address: ");                                //
                address1 = input.next() + " "                                   //  Address is in the form of 
                        + String.valueOf(input.nextInt());                      // "Street"(-space-)"Number".
                System.out.println("Apartment's capacity (number of people): ");//
                capacity = input.nextInt();                                     // Inpurs apartment's capacity.
                System.out.println("Number of bedrooms: ");                     //
                bedrooms = input.nextInt();                                     // Inputs number of bedrooms.
                System.out.println("Does it have web service? (Yes/No) ");      //
                String web = input.next();                                      //- Inputs web connection existence ("yes"/"no")
                webS = web.toLowerCase().contains("yes");                       // It is converted to ("True"/"False")
                System.out.println("Does it have a television? (Yes/No) ");     // for the system to be able to process it.
                String tv = input.next();                                       //- Inputs TV existence ("yes"/"no")
                tvS = tv.toLowerCase().contains("yes");                         // It is converted to ("True"/"False")
                System.out.println("Does it contain a kitchen? (Yes/No) ");     // for the system to be able to process it.
                String kitchen = input.next();                                  //- Inputs Kitchen existence ("yes"/"no")
                kitchenS = kitchen.toLowerCase().contains("yes");               // It is converted to ("True"/"False")
                System.out.println("Does it have a private parking? (Yes/No) ");// for the system to be able to process it.                                                      //
                String parking = input.next();                                  //- Inputs Private parking existence ("yes"/"no")
                parkingS = parking.toLowerCase().contains("yes");               // It is converted to ("True"/"False")
                System.out.println("Does it have a view of Street, Mountain "   // for the system to be able to process it.    
                        + "or Sea?\n(Choose one or more)");                     //
                view = input.next();                                            // Inputs apartment's view(Street/Mountain/Sea).
                System.out.println("Distance from the closest "                 //
                        + "metro station? (in meters)");                        //
                Mdistance = input.nextDouble();                                 //- Inputs distance from closet metro station.
                System.out.println("What is the daily cost?");                  // (in meters)
                cost = input.nextFloat();                                       //- Inputs apartment's cost per day.
                System.out.println("Which is the floor of the apartment?");     // (in €)
                floor = input.nextInt();                                        //- Inputs the apartment's floor.
                System.out.println("Is there an elevator? (Yes/No) ");          //
                String elev = input.next();                                     //- Inputs Elevator existence ("yes"/"no")
                elevS = elev.toLowerCase().contains("yes");                     // It is converted to ("True"/"False")
                System.out.println("Does it have a balcony? (Yes/No) ");        // for the system to be able to process it.    
                String balcon = input.next();                                   //- Inputs Balcony existence ("yes"/"no")
                balconS = balcon.toLowerCase().contains("yes");                 // It is converted to ("True"/"False")
                break;
            } catch (InputMismatchException e) {
                String str = input.nextLine();
                System.out.println("Something went wrong. Please try following "
                        + "the instructions of every question. You entered " 
                        + str + " instead of that, the system wants.\n");
            }
        } while (true);    
        Apartment apartment = new Apartment(municipality,                       // for the system to be able to process it.   
                address1, vat, capacity, bedrooms, webS, tvS,                   //- An Apartment object is created with 
                kitchenS, parkingS, view, Mdistance, cost,                      // the attributes the user entered.
                floor, elevS, balconS );                                        //
        residenceArray.add(apartment);                                          //- The new apartment is added to the ArrayList.
        System.out.println("New apartment added and is given the Verification"  //
                + " number: " + apartment.getVerificID(residenceArray));        //- Apartment's Verification ID is created.
        System.out.println("Owner's full name: " + getFullName());              //
        System.out.println("Apartment's info: \n"                               //- Apartment's info is printed on the screen.
                + apartment.toString(residenceArray));                          //
        Calendar date = Calendar.getInstance();                                 //- Creating an instance for today's system date.
        Reservation reserve = new Reservation(municipality,                     //- Creating a Reservation object, to hold the
                vat, -1, date, date, cost);                                     // new apartment, with tenant's VAT number equal
        reservationArray.add(reserve);                                          // to -1, and reservation dates equal to today's
    }                                                                           // date. So, this doesn't count as a reservation.
                                                                                // but, it's there to be used when someone 
                                                                                // reserves it, by changing its attributes.
    public void registerDetatchedHouse(ArrayList <Residence> residenceArray,    //- This method registers a new detatched house.
            ArrayList <Owner> ownerArray,                                       //
            ArrayList <Reservation> reservationArray, int vat) {                //
        System.out.println("Enter your detatched house by giving the following" //
                + " info:\nMunicipality: ");                                    //
        String municipality = input.next();                                     //- Inputs detatched house's municipality.
        System.out.println("Address: ");                                        //
        String address1 = input.next() + " " + String.valueOf(input.nextInt()); //- Address is in the form of 
        System.out.println("Apartment's capacity (number of people): ");        // "Street"(-space-)"Number".
        int capacity = input.nextInt();                                         //- Inputs detatched house's capacity.
        System.out.println("Number of bedrooms: ");                             //
        int bedrooms = input.nextInt();                                         //- Inputs number of bedrooms.
        System.out.println("Does it have web service? (Yes/No) ");              //
        String web = input.next();                                              //- Inputs web connection existence ("yes"/"no")
        boolean webS = web.toLowerCase().contains("yes");                       // It is converted to ("True"/"False")
        System.out.println("Does it have a television? (Yes/No) ");             // for the system to be able to process it.                                                           
        String tv = input.next();                                               //- Inputs TV existence ("yes"/"no")
        boolean tvS = tv.toLowerCase().contains("yes");                         // It is converted to ("True"/"False")
        System.out.println("Does it contain a kitchen? (Yes/No) ");             // for the system to be able to process it. 
        String kitchen = input.next();                                          //- Inputs Kitchen existence ("yes"/"no")
        boolean kitchenS = kitchen.toLowerCase().contains("yes");               // It is converted to ("True"/"False")
        System.out.println("Does it have a private parking? (Yes/No) ");        // for the system to be able to process it.
        String parking = input.next();                                          //- Inputs Private parking existence ("yes"/"no")
        boolean parkingS = parking.toLowerCase().contains("yes");               // It is converted to ("True"/"False")
        System.out.println("Does it have a view of Street, Mountain or Sea? "   // for the system to be able to process it.
                + "\n(Choose one or more)");                                    //
        String view = input.next();                                             //- Inputs detatched house's view(Street/Mountain
        System.out.println("Distance from the closest "                         // /Sea).
                + "metro station? (in meters)");                                //
        double Mdistance = input.nextDouble();                                  //- Inputs distance from closest metro station.
        System.out.println("What is the daily cost?");                          // (in meters)
        float cost = input.nextFloat();                                         //- Inputs detatched house's cost per day.
        System.out.println("Enter the garden's size [in square meters(without"  // (in €)
                + " the unit of measure) ]. If there isn't one, enter '0'");    //
        double garden = input.nextDouble();                                     //- Inputs Garden's size (in m^2)
        System.out.println("Enter the swimming pool's size [in square meters"   // (0.0 if there is no garden.)
                + "(without the unit of measure) ]. "                           //
                + "If there isn't one, enter '0'");                             //
        double spool = input.nextDouble();                                      //- Inputs Swimming pool's size (in m^2)
        System.out.println("Does it have a barbeque? (Yes/No) ");               // (0.0 if there is no swimming pool.)
        String barb = input.next();                                             //- Inputs Private parking existence ("yes"/"no")
        boolean barbS = barb.toLowerCase().contains("yes");                     // It is converted to ("True"/"False")
        DetatchedHouse detatched = new DetatchedHouse(municipality,             // for the system to be able to process it. 
                address1, vat, capacity, bedrooms, webS, tvS,                   //- A DetatchedHouse object is created
                kitchenS, parkingS, view, Mdistance, cost,                      // with the attributes the user entered.
                garden, spool, barbS);                                          //
        residenceArray.add(detatched);                                          //- The detatched house is added to the ArrayList.
        System.out.println("New detatched house added and is given the "        //
                + "Verification ID: "                                           //
                + detatched.getVerificID(residenceArray));                      //- Apartment's Verification ID is created.
        System.out.println("Owner's full name: " + getFullName());              //
        System.out.println("Detatched house's info:\n" + detatched.toString()); //- Apartment's info is printed on the screen.
        Calendar date = Calendar.getInstance();                                 //- Creating an instance for today's system date.
        Reservation reserve = new Reservation(municipality,                     //- Creating a Reservation object, to hold the
                vat, -1, date, date, cost);                                     // new detatched house, just like we did with
        reservationArray.add(reserve);                                          // the apartment. More details there
    }                                                                           // (The method above this one).
    
    public int registerOwner(ArrayList <Owner> ownerArray, int position,        //
            int vat) {                                                          // User doesn't exist in the system,
            System.out.println("New owner! Please register by giving the "      // so he registers as a new owner.
                    + "following info:\nFirst name: ");                         //
            String firstname = input.next();                                    // Inputs first name.
            System.out.println("Last name: ");                                  //
            String lastname = input.next();                                     // Inputs last name.
            System.out.println("Your home address:\n(Enter the street"          //
                    + " and the number, with a -space- between them)");         //
            this.address = input.next() + " "                                   //  Address is in the form of 
                    + String.valueOf(input.nextInt());                          // "Street"(-space-)"Number".
            do {    
                do {
                    try {
                        System.out.println("Your ID number: ");                 //
                        this.id = input.nextInt();                              // (The id is a number to make things easier).
                        break;
                    } catch (InputMismatchException e) {                        //-We use the InputMismatchException to support
                        String str = input.nextLine();                          // the program if the user gives something, other
                        System.out.println("ID must be a 6-digit number. You "  // than an integer.
                                + "entered " + str + " which is a different "
                                        + "datatype. Please try again.");
                    }
                } while (true);
            } while (backup.isIncorrectVat(id));                               //-To make sure the number won't have more than 6 digits
            while (String.valueOf(id).length() < 6) {                           //-If VAT number entered, has less than 6-digits
                id *= 10;                                                       // we add zeros, to make it a 6-digit number.
            }                                                                   //
            while (String.valueOf(vat).length() < 6) {                          //-If VAT number entered, has less than 6 digits
                vat *= 10;                                                      // we add zeros, to make it a 6-digit number.
            }                                                                   //
            Owner owner = new Owner(vat, firstname, lastname,                   //  TODO ID: exception if its lesser than 6 numbers. Or the user enters chars.
                    address, id);                                               // The new owner object is created 
            ownerArray.add(owner);                                              // and added to its ArrayList.            
            System.out.println("New owner added! Info: "                        //
                    + ownerArray.get(ownerArray.size()-1).toString());          //
            return (ownerArray.size()-1);                                       // The new position gets this returned value.
    }                                                                           
    
    public void registerResidence (ArrayList <Owner> ownerArray,                //
            ArrayList <Residence> residenceArray,                               //
            ArrayList <Reservation> reservationArray) {                         //
        int position = -1;                                                      //
        int vat;                                                                //
        System.out.println("You chose to register a new residence.\n");
        do {
            do {                                                                //
                try {                                                           //
                    System.out.println("Please enter your VAT Number: ");       //
                    vat = input.nextInt();                                      //- User enters his VAT number to 
                    break;                                                      //  be checked by the system.
                } catch (InputMismatchException e) {                            //- We use an InputMismatchException handler
                    input.nextLine();                                           //  to handle the situation of the user inputing
                    System.out.println("VAT number cannot be of the type you "  //  something that's not a number.
                            + "entered. \nPlease enter a 6 digit number!");     //
                }                                                               //
            } while (true);                                                     //
        } while (backup.isIncorrectVat(vat));
        for (int i = 0; i < ownerArray.size(); i++) {                           //
            if (vat == ownerArray.get(i).getVatNumber()){                       //
               position = i;                                                    //
            }                                                                   //
        }                                                                       //
        if (position == -1) {                                                   //- position == -1 means that the user's VAT
            position = ownerArray.get(ownerArray.size()-1).registerOwner        //  number, doesn't exist in the system. So, we
                                            (ownerArray, position, vat);        //  call this Owner's method (registerOwner) to
        } else {                                                                //  register a new owner. Position is returned.
            System.out.println("Owner exists! Full name: "                      //- With position != -1, it means that the 
                            + ownerArray.get(position).getFullName());          //  user's VAT number exists, so the process
        }                                                                       //  continues with him selecting, which type
                                                                                //  of residence, he wants to register.
        int choice;                                                             //
        do {                                                                    //- User chooses whether to register
            do {                                                                //  an apartment (Enter '1') or 
                try {                                                           //  a detatched house (Enter '2').
                    System.out.println("Enter '1' to register an Apartment - "  //
                            + "Enter '2' to register a Detatched House");       //- We use an InputMismatchException handler
                    choice = input.nextInt();                                   //  to handle the situation of the user inputing
                    break;                                                      //  something that's not a number.
                } catch (InputMismatchException e) {                            //
                    String str = input.nextLine();                              //
                    System.out.println("You option must be between 1 and 2. "   //
                            + "You entered " + str);                            //
                }                                                               //
            } while (true);                                                     //
            switch (choice) {                                                   //
                case 1:                                                         //
                    ownerArray.get(position).registerApartment                  //- This Owner's method, registers an apartment,
                    (residenceArray, ownerArray, reservationArray, vat);        //  taking as parameters these 3 ArrayLists,
                    break;                                                      //  plus the vat number of the owner.
                case 2:                                                         //
                    ownerArray.get(position).registerDetatchedHouse             //- This Owner's method, registers a detathced
                    (residenceArray, ownerArray, reservationArray, vat);        //  house, taking as parameters these 3 
                    break;                                                      //  ArrayLists, plus the vat number of the owner.
                default:                                                        //
                    System.out.println("Invalid option! Please "                //- If the users doesn't input '1' or '2'
                            + "enter '1' or '2' only!");                        //  the process is repeated.
                    break;                                                      //
            }                                                                   //
        } while ((choice != 1) && (choice != 2));                               //
    }
}