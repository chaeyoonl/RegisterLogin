package com.app.registerlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView tv_id, tv_pass;
    Button btn_map;

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰 하단 바
    private FragmentManager fm;
    private FragmentTransaction ft;
    private NoticeFrag frag_notice;
    private FriendFrag frag_friend;
    private PlaceFrag frag_place;
    private ChatFrag frag_chat;
    private ProfileFrag frag_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_notice:
                        setFrag(0);
                        break;
                    case R.id.action_friend:
                        setFrag(1);
                        break;
                    case R.id.action_place:
                        setFrag(2);
                        break;
                    case R.id.action_chat:
                        setFrag(3);
                        break;
                    case R.id.action_profile:
                        setFrag(4);
                        break;

                }
                return true;






            }
        });

        frag_notice = new NoticeFrag();
        frag_friend = new FriendFrag();
        frag_place = new PlaceFrag();
        frag_chat = new ChatFrag();
        frag_profile = new ProfileFrag();


        setFrag(0); //첫화면



    }
    //프래그먼트 화면교체 실행문
    private void setFrag(int n)
    {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n)
        {
            case 0:
                ft.replace(R.id.main_frame,frag_notice);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frag_friend);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag_place);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag_chat);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,frag_profile);
                ft.commit();
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    //우측상단 메뉴
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG);



        switch(item.getItemId())
        {
            case R.id.action_live:
                toast.setText("중계");
                break;
            case R.id.action_team:
                toast.setText("동호회 구하기");
                break;
            case R.id.action_import:
                toast.setText("대회 정보");
                break;
            case R.id.action_rank:
                toast.setText("랭킹");
                break;
            case R.id.action_map:
                toast.setText("지도");
                Intent homeIntent = new Intent(this, MainMap.class);
                startActivity(homeIntent);

                break;
            case R.id.action_logout:
                toast.setText("로그아웃");
                break;
        }



        toast.show();

        return super.onOptionsItemSelected(item);
    }



}

