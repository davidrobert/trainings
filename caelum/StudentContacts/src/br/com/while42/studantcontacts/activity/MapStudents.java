package br.com.while42.studantcontacts.activity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import br.com.while42.studantcontacts.R;
import br.com.while42.studantcontacts.model.Student;
import br.com.while42.studantcontacts.persist.StudentDAO;
import br.com.while42.studantcontacts.view.StudentOverlay;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

public class MapStudents extends MapActivity {

	private MapController mapController;

	private LocationListener locationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			updateMyLocation(location);
		}

		@Override
		public void onProviderDisabled(String provider) {
			updateMyLocation(null);
		}		

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {			
		}

	};

	private MapView mapView;

	private void updateMyLocation(Location location) {
		if (location != null) {
			Double geoLat = location.getLatitude() * 1E6;
			Double geoLng = location.getLongitude() * 1E6;
			GeoPoint point = new GeoPoint(geoLat.intValue(), geoLng.intValue());

			mapController.animateTo(point);
		}
	}

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.map);

		mapView = (MapView) findViewById(R.id_map.mapViewLocation);

		mapView.setSatellite(false);
		mapView.setStreetView(true);
		mapView.displayZoomControls(true);
		mapView.setBuiltInZoomControls(true);

		mapController = mapView.getController();
		mapController.setZoom(15);

		List<Overlay> overlays = mapView.getOverlays();
		MyLocationOverlay myLocationOverlay = new MyLocationOverlay(this, mapView);
		overlays.add(myLocationOverlay);
		myLocationOverlay.enableCompass();
		myLocationOverlay.enableMyLocation();

		LocationManager manager = (LocationManager)getSystemService(LOCATION_SERVICE);
		Criteria c = new Criteria();
		c.setAccuracy(Criteria.ACCURACY_COARSE);

		String provider = manager.getBestProvider(c, true);
		Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		updateMyLocation(location);

		manager.requestLocationUpdates(provider, 2000, 20, locationListener);

		// Mostrar todos os alunos cadastrados por meio de overlay sobre o mapa

		StudentDAO dao = new StudentDAO(MapStudents.this);
		List<Student> students = dao.getList();
		dao.close();

		Geocoder geo = new Geocoder(MapStudents.this, Locale.getDefault());	
		
		for (Student student: students) {
			Address address = null;			
			
			try {
				List<Address> addresses = geo.getFromLocationName(student.getAddress(), 1);
				
				if (addresses.size() > 0) address = addresses.get(0);
			} catch (IOException e) {
				Log.i("ERROR", "Ops! Baleiando!");
				e.printStackTrace();
			}
			
			if (address != null) {
				Bitmap bitmap = BitmapFactory.decodeResource(MapStudents.this.getResources(), R.drawable.noimage);
				if (student.getPhoto() != null) {
					try {		
						FileInputStream fis = new FileInputStream(student.getPhoto());
						bitmap = BitmapFactory.decodeStream(fis);
						fis.close();
						bitmap = Bitmap.createScaledBitmap(bitmap, 30, 30, true);
					} catch (IOException e) {
						Log.i("ERROR", "Ops! Baleiando!");
						e.printStackTrace();						
					}
				}
				
				StudentOverlay myOverlay = new StudentOverlay(address, bitmap);
				mapView.getOverlays().add(myOverlay);
			}						
		}
		
		mapView.invalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
