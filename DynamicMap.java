package com.drivespace;

/**
 *
 * @author Nhat Su
 */

/** This program show the map with available spot in the parking lot. 
 * newParkingLot: to show new parkingLot that available 
 * newMap: to find and update the Map that parking lot available 
 */

public class DynamicMap {
    
   private ParkingLot newParkingLot;
   private Map newMap;

   // constructor to initializes the newly created object before it is used 
    public DynamicMap(ParkingLot newParkingLot, Map newMap) {
        this.newParkingLot = newParkingLot;
        this.newMap = newMap;
    }

    
    // return a new parking lot
    public ParkingLot getNewParkingLot() {
        return newParkingLot;
    }
    
    // return new map
    public Map getNewMap() {
        return newMap;
    }
    
    
    // adjust and update new parking lot
    public void setNewParkingLot(ParkingLot newParkingLot) {
        this.newParkingLot = newParkingLot;
    }
    
    //adjust and update new map
    public void setNewMap(Map newMap) {
        this.newMap = newMap;
    }
  
}
