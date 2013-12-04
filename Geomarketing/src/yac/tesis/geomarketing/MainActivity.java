package yac.tesis.geomarketing;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private GoogleMap map;
	private static final LatLng MELBOURNE = new LatLng(-37.81319, 144.9629);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        
        //creando la variable market el cual mostrar la marca en el mapa
        Marker melboure = map.addMarker(new MarkerOptions().position(MELBOURNE).title("melbourne").snippet("Poblacion 4.000.000").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        
        //Agregando un market en el mapa de la aplicacion
        map.addMarker(new MarkerOptions().position(new LatLng(-17.391991,-66.153271)).title("aca estoy"));
        
        //Agregando un mensaje de fondo negro que indica el title del market en donde pinchamos
        map.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), arg0.getTitle(),Toast.LENGTH_LONG ).show();
				return false;
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
