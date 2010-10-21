package jp.cnu.android.mapionmap;

import jp.co.mapion.android.maps.*;
import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MapionMapsActivity extends MapActivity implements LocationListener {
    MapView mapView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);

        LocationManager l = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        l.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        String apikey = "APIKEY";
        mapView = new MapView(this, apikey);
        layout.addView(mapView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public void onLocationChanged(Location location) {
        mapView.getController().animateTo(new GeoPoint((int) (location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6)));
    }
    
    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}