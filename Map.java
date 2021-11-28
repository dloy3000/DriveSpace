package com.drivespace;

/**
 *
 * @author Devon Loy
 */

//Java library imports.
import java.util.Arrays;
import java.util.List;

//Android SDK imports.
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.RequiresPermission;

//Google Cloud Services imports.
import com.google.android.gms.tasks.Task;

import com.google.android.libraries.places.api.Places;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.Place.Field;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import static android.Manifest.permission.ACCESS_WIFI_STATE;

public class Map extends AppCompatActivity {
    private String lotName;
    private String address;

    private List<String> hours;
    private String phone;
    private int price;

    private String lotID;

    private ParkingLot parkingLot; //Container for ParkingLot Class.

    /**
     * Creates a map object from a given Google Place ID.
     * This object stores both information and access to the given
     * place for later usage.
     * @param lotID The Place ID of a target parking lot.
     */
    @RequiresPermission(allOf = {ACCESS_WIFI_STATE})
    public Map(String lotID, ParkingLot parkingLot){
        this.lotID = lotID;
        this.parkingLot = parkingLot;

        PlacesClient client = Places.createClient(this); //Client must be initialized with api key.
        Place lot = accessPlace(client, lotID);

        this.address = lot.getAddress();
        this.lotName = lot.getName();
        this.hours = lot.getOpeningHours().getWeekdayText();
        this.phone = lot.getPhoneNumber();
        this.price = lot.getPriceLevel();
    }

    /**
     * Helper method which accesses a given map location
     * based on the provided Place ID.
     * @param client A PlacesClient object.
     * @param placeID The Place ID of a target location.
     * @return Place object of the target location.
     */
    private Place accessPlace(PlacesClient client, String placeID){
        //Fetch place information
        List<Field> fields = Arrays.asList(new Field[]{Field.NAME, Field.ADDRESS, Field.OPENING_HOURS, Field.PHONE_NUMBER, Field.PRICE_LEVEL});
        FetchPlaceRequest request = FetchPlaceRequest.builder(lotID, fields).build();

        Task<FetchPlaceResponse> responseTask = client.fetchPlace(request);
        FetchPlaceResponse response =  responseTask.getResult();

        Place targetLot = response.getPlace();
        return targetLot;
    }

    /**
     * @return Name of the parking lot.
     */
    public String getLotName() {
        return lotName;
    }

    /**
     * @return Address of the parking lot.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return Operating hours of the parking lot.
     */
    public List<String> getHours() {
        return hours;
    }

    /**
     * @return Business contact number.
     */
    public String getContact() {
        return phone;
    }

    /**
     * @return General price level associated with the parking lot.
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return Place ID of the parking lot.
     */
    public String getLotID() {
        return lotID;
    }

    /**
     * @return ParkingLot object associated with this Map object.
     */
    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
