package com.drivespace;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private PlacesClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Initialize the SDK
        Places.initialize(getApplicationContext(), "AIzaSyCHooFYiGz2x4uWG0oLdY-kGlXTV7qRQRU");

        client = Places.createClient(this); //Client must be initialized with api key.
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Map lot = createSampleMap();

        // Add a marker in Sydney and move the camera
        LatLng walker = new LatLng(36.068181881660195, -79.81209261755306);

        String str = "Walker Avenue Parking Deck";
        String txt = "Available Spots: 12  Premium Spots: 3\nClick to reserve..";
        mMap.addMarker(new MarkerOptions().position(walker).title(str).snippet(txt).draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(walker));

    }

    public Map createSampleMap(){
        ParkingLot lot = new ParkingLot("Devon Loy", 25);
        Map map = new Map("ChIJRRWT70EZU4gRaoBKHGC" ,lot, client); //Walker Ave Parking Deck

        return map;
    }
}