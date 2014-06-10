package br.com.season.laboratorio1;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.hardware.SensorManager;
import android.location.Location;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.squareup.seismic.ShakeDetector;
import com.squareup.seismic.ShakeDetector.Listener;

public class MainActivity extends FragmentActivity implements ConnectionCallbacks, OnConnectionFailedListener,
	LocationListener, Listener {

	private GoogleMap mapa;
	private LocationClient locationClient;
	private List<LatLng> posicoes = new ArrayList<LatLng>();
	
	private static final LocationRequest REQUEST = LocationRequest.create()
			.setInterval(5000)
			.setFastestInterval(16)
			.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
	
	private void configurarLocationClienteSeNecessario() {
		if (locationClient == null) {
			locationClient = new LocationClient(this, this, this);
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapa = fragment.getMap();
        mapa.setMyLocationEnabled(true);
        
        mapa.addMarker(new MarkerOptions().position(new LatLng(0.0, 0.0))
        		.title("Meu Primeiro Marcador")
        		.icon(BitmapDescriptorFactory.defaultMarker()));
        
        CameraPosition camera = new CameraPosition.Builder().target(new LatLng(-23.1895062, -45.8630128))
        		.zoom(12.0f).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(camera);
        mapa.moveCamera(update);
        
        new Thread(new Runnable() {			
			@Override
			public void run() {
				try { Thread.sleep(3000); } catch (Exception e) {}
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						CameraPosition camera = new CameraPosition.Builder().target(new LatLng(-19.9026958,-43.9640349))
				        		.zoom(12.0f).build();
				        CameraUpdate update = CameraUpdateFactory.newCameraPosition(camera);
				        mapa.animateCamera(update);						
					}
				});
			}
		}).start();
        
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	configurarLocationClienteSeNecessario();
    	locationClient.connect();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	if (locationClient != null) {
    		locationClient.disconnect();
    	}
    }

	@Override
	public void onConnectionFailed(ConnectionResult result) {		
	}

	@Override
	public void onConnected(Bundle bundle) {
		locationClient.requestLocationUpdates(REQUEST, this);
		
	}

	@Override
	public void onDisconnected() {		
	}

	@Override
	public void onLocationChanged(Location location) {
		/*mapa.clear();
		CameraPosition camera = new CameraPosition.Builder().target(new LatLng(location.getLatitude(), 
				location.getLongitude())).zoom(18.0f).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(camera);
        mapa.animateCamera(update);
        mapa.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude()))
        		.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));*/
		
		mapa.clear();
		posicoes.add(new LatLng(location.getLatitude(), location.getLongitude()));
		PolylineOptions lineOptions = new PolylineOptions();
		for (LatLng pos : posicoes) {
			lineOptions.add(pos);
		}
		lineOptions.color(Color.RED);		
		mapa.addPolyline(lineOptions);
	}

	@Override
	public void hearShake() {
		Uri notificacao = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		Ringtone toque = RingtoneManager.getRingtone(this, notificacao);
		try { toque.play(); } catch (Exception e) {}
	}
    
}
