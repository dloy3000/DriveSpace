package com.drivespace;

import java.util.Random;
import java.util.Scanner;

public class ParkingLot {
    private String companyOwner = "";           //owner name    
    private int lotSize = 0;                    //lot size
    private int spotsTaken = 0;                 //spots filled
    private boolean[] lot = new boolean[0];     //parking lot array used to check
                                                //availible parking
    
    //Place Holder Values For Testing
    private boolean spotStatus = false;
    private int spotID = 2;
    private String spotType = "General Parking";
    /*
     * Initializes the parking lot 
     * @param owner - lot owner's name
     * @param size - initial size
     */
    public ParkingLot(String owner, int size){
        
        this.companyOwner = owner;
        this.lotSize = size;
        this.lot = new boolean[size];
    }
    /*
     * Fetches the amount of parking spots availible, if there are spots they
     * are listed, if none are availible then it is displayed as such.
     */
    public void getParkingSpots(){
        System.out.println("\nThere are " + (lotSize - spotsTaken) + " spots availible");
        int full = 0;
        System.out.print("Parking spot(s) ");
        
        //Runs a check on what spots are availible
        for(int i = 0; i < lot.length; i++){        
            if(lot[i] == false){
                System.out.print( (i+1) + ", ");
            }else{
                full++;
            }
        }
            if(full == lot.length){
                System.out.println("are all taken!");
            }else{
                System.out.println("are availible!");
        }
}  
    /*
     *Gets the size of the parking lot 
     */
    public void getLotSize(){
        System.out.println("\nThis parking lot has a total of " + lotSize + " spaces.");
    }
    /*
     *Obtains the owner of the lot 
     */
    public void getOwner(){
        System.out.println(this.companyOwner + " is the owner of this lot.");
    }
    /*
     * Transfers ownership of the lot 
     * @param name - new owner name
     */
    public void changeOwner(String name){
        System.out.println("\nTransferring ownership from " + this.companyOwner + " to " +
                name);
        this.companyOwner = name;
        System.out.println(this.companyOwner + " is now the new owner of this lot!");
    }
    /*
     * Adds parking spaces to the lot and translates the old array to the new lot
     * @param amount - amount added
     */
    public void addParkingSpot(int amount){
        int i = this.lot.length;
        
        System.out.println("\nAdding " + amount + " spaces. . .");

        this.lotSize = lotSize + amount;
        boolean[] newLot = new boolean[lotSize];
        for(int n = 0; n < i; n++){                     //translates the old data
            newLot[n] = this.lot[n];                    //lot to the new lot
        }
        this.lot = new boolean[lotSize];
        this.lot = newLot;
        System.out.println("The parking lot now has " + lotSize + " spaces.");
    }
    /*
     * Allows for the parking spots from the parkingSpot class to be altered
     * The Spots' ID, Type and if it is filled or not can be updated here.
     */
    public void editParkingSpot(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the spot number you would like to edit: ");
        int spotValue = input.nextInt();
        
        ////Fetch the parking spot class at this.lot[spotValue]
        ////to gather the spot data and display it
        
        this.spotID = spotValue;
        
        //Prompts the user for the feature they want to edit
        System.out.println("Would you like to edit:\n 1. The spot status.\n" + 
                " 2. The spot ID\n 3. The spot's type?.");
        System.out.print("Please enter the field you would like to edit: ");
        int edit = input.nextInt(); 
        
        //Depending on the answer the proper case is selected
        switch(edit){
            case 1:                                     //Set Status chosen
                System.out.print("\nPlease enter the new status: ");
                boolean status = input.nextBoolean();
                this.spotStatus = status;
                break;
            case 2:                                     //Set ID chosen
                System.out.print("\nPlease enter the new ID: ");
                int id = input.nextInt();
                this.spotID = id;
                break;
            case 3:                                     //Set Type chosen
                System.out.print("\nPlease enter, General, Handicapped, or Premium" +
                        " as the new type: ");
                String type = input.next();
                this.spotType = type;
                break;
            default:                                    //invailid option selected
                System.out.println("Invailid option!");
                break;
        }     
        //Prints Data of Parking Spot
        System.out.println("\nSpot number " +this.spotID+ "'s data:\n" +
                "Taken: " + this.spotStatus + "\nID: "+ this.spotID + 
                "\nType: " + this.spotType);
    }
    /*
     * Removes parking spots and translates the array, cars in deleted spots are destroyed.
     * @param amount - amount removed
     */
    public void deleteParkingSpot(int amount){
        int i = this.lot.length;
        System.out.println("\nRemoving " + amount + " spaces. . .");
        this.lotSize = lotSize - amount;
        boolean[] newLot = new boolean[lotSize];
        for(int n = 0; n < lotSize; n++){               //The old data is moved
            newLot[n] = this.lot[n];                    //to the updated lot
        }
        this.lot = new boolean[lotSize];
        this.lot = newLot;
        System.out.println("The parking lot now has " + lotSize + " spaces.");
    }
    /*
     * Temporary code to simulate a random amount of people parking in random parking spots. 
     * Used for testing and can be removed later.
     */
    public void park(){
        Random r = new Random();
        int parking = r.nextInt(lotSize + 1);
        for(int i = 0; i < parking; i++){
            int parked = r.nextInt(lotSize);
            while(this.lot[parked] == true){
                parked = r.nextInt(lotSize);
            }
            this.lot[parked] = true;
            this.spotsTaken++;
        }
    }
}