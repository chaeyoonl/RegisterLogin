package com.app.registerlogin;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//import androidx.fragment.app.FragmentManager;

public class MainMap extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManager;
    private MapFragment mapFragment;
    private View view;
    private Button btn_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
        //나가기
        btn_out = findViewById(R.id.btn_out);
        btn_out.setOnClickListener(new View.OnClickListener() { //나가기 버튼을 클릭 시 수행 하는 곳
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMap.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(37.209262, 126.976446); //수원대 위치
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("수원대");
        markerOptions.snippet("대학교");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
        //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }
}