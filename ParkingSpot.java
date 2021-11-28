package com.drivespace;

/**
 *
 * Code by Grant Welton
 */
public class ParkingSpot {
    
    /*Class Variables
    status: Availablility of spot
    spot_ID: ID number of parking spot
    spot_Type: Type of spot (Premium, Handicapped, General Parking)
    */
    
    Boolean status;
    int spot_ID;
    String spot_Type;
     
  
    
    /*
    getStatus: returns the status of a parking spot.
    */
    public static Boolean getStatus(ParkingSpot A){
        return A.status;
    }
    
    /*
    setStatus: takes a parking spot and a boolean value and allows spot status to be changed.
    */
    private static void setStatus(ParkingSpot A, boolean new_Status){
        A.status = new_Status;
    }
    
    /*
    getSpotID: returns the ID number of a parking spot.
    */
    public static int getSpotID(ParkingSpot A){
        return A.spot_ID;
    }
    
    /*
    setSpotID: takes a parking spot and a int value and allows spot ID to be changed.
    */
    private static void setSpotID(ParkingSpot A, int new_ID){
        A.spot_ID = new_ID;
    }
    
    /*
    getSpotType: returns the spot type of a parking spot.
    */
    public static String getSpotType(ParkingSpot A){
        return A.spot_Type;
    }
    
    /*
    setSpotType: takes a parking spot and a String value and allows spot type to be changed.
    */
    private static void setSpotType(ParkingSpot A, String new_Type){
        A.spot_Type = new_Type;
    }
    
    /*
    isReservable: returns a boolean value based on whether a spot is premium or not.
    */
    public static Boolean isReservable(ParkingSpot A){
        return A.spot_Type.equals("Premium") && A.status.equals(true);
    }

}
