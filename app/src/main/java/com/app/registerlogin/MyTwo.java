package com.app.registerlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyTwo extends AppCompatActivity   {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<ChatData> chatList;
    //private List<ChatData> title;
    String nick = "nick3";
    //private String nicks = "nick3";

    EditText EditText_chat;
    EditText EditText_player;
    EditText EditText_chat_ex;
    Button Button_send;
    Button Button_ext;
    RatingBar rbar;
    RadioGroup radioGroup0;
    RadioButton radio0;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioGroup radioGroup1;
    RadioButton radio_0;
    RadioButton radio_1;
    RadioButton radio_2;
    RadioButton radio_3;
    int h, j;

    DatabaseReference myRef;



    /*
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio0:
                    h = 0;
                    break;
            case R.id.radio1:
                    h = 1;
                    break;
            case R.id.radio2:
                    h = 2;
                    break;
            case R.id.radio3:
                    h = 3;
                    break;
        }


    }


     */




    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_two);


        Button_send = findViewById(R.id.Button_send);
        Button_ext = findViewById(R.id.Button_ext);
        EditText_chat = findViewById(R.id.EditText_chat);
        EditText_player = findViewById(R.id.EditText_player);
        EditText_chat_ex = findViewById(R.id.EditText_chat_ex);
        rbar = findViewById(R.id.rbar);
        radioGroup0 = findViewById(R.id.radioGroup0);
        radio0 = findViewById(R.id.radio0);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radio_0 = findViewById(R.id.radio_0);
        radio_1 = findViewById(R.id.radio_1);
        radio_2 = findViewById(R.id.radio_2);
        radio_3 = findViewById(R.id.radio_3);





        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        //종목 버튼을 눌렀을 때 db에 넘겨줄 값 부분
        radio0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = 0;
            }
        });
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = 1;
            }
        });
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = 2;
            }
        });
        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = 3;
            }
        });


        //지역 부분을 눌렀을 때 db에 넘겨줄 값 부분
        radio_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = 0;
            }
        });
        radio_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = 1;
            }
        });
        radio_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = 2;
            }
        });
        radio_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = 3;
            }
        });





        Button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = EditText_chat.getText().toString(); //msg
                String msg2 = EditText_player.getText().toString(); //msg
                String msg3 = EditText_chat_ex.getText().toString(); //msg
                float msg4 = rbar.getRating(); //msg
                Integer msg5 = radioGroup0.getBottom(); //msg
                Integer msg6 = radioGroup1.getBottom(); //msg





                /*

                //라디오 그룹 클릭 리스너
                RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
                    @Override public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                        if(i == R.id.radio0){
                            h = 0;
                        } if(i == R.id.radio1){
                            h = 1;
                        } if(i == R.id.radio2){
                            h = 2;
                        } if(i == R.id.radio3){
                            h = 3;
                        }} };


                 */






                if(msg != null) {
                    final ChatData chat = new ChatData();
                    //ChatData chat2 = new ChatData();
                    chat.setNickname(nick);
                    //chat.setNickname(nick);
                    chat.setMsg(msg);
                    //myRef.push().setValue(chat);
                    chat.setMsg2(msg2);
                    chat.setMsg3(msg3);
                    chat.setMsg4(msg4);

                    msg5 = h;
                    chat.setMsg5(msg5);

                    msg6 = j;
                    chat.setMsg6(msg6);

                    //chat.setMsg5(msg5);
                    myRef.push().setValue(chat);
                    //myRef.push().setValue(chat);
                    //chat.setMsg(msg2);
                    //myRef.push().setValue(chat);

                }




                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        post.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다







            }

        });


        Button_ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        post.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다







            }

        });






        //db값을 받아와서 화면에 띄워주는 부분

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        chatList = new ArrayList<>();
        //title = new ArrayList<>();
        mAdapter = new ChatAdapter(chatList, MyTwo.this, nick);

        mRecyclerView.setAdapter(mAdapter);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        myRef = database.getReference();


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Log.d("CHATCHAT", dataSnapshot.getValue().toString());
                ChatData chat = dataSnapshot.getValue(ChatData.class);
                ((ChatAdapter) mAdapter).addChat(chat);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

































    }













/*

    @IgnoreExtraProperties
    public class FirebasePost {
        public String id;
        public String name;
        public Long age;
        public String gender;

        public FirebasePost(){
            // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
        }

        public FirebasePost(String id, String name, Long age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Exclude
        public Map<String, Object> toMap() {
            HashMap<String, Object> result = new HashMap<>();
            result.put("id", id);
            result.put("name", name);
            result.put("age", age);
            result.put("gender", gender);
            return result;
        }

        public void postFirebaseDatabase(boolean add){
            mPostReference = FirebaseDatabase.getInstance().getReference();
            Map<String, Object> childUpdates = new HashMap<>();
            Map<String, Object> postValues = null;
            if(add){
                FirebasePost post = new FirebasePost(ID, name, age, gender);
                postValues = post.toMap();
            }
            childUpdates.put("/id_list/" + ID, postValues);
            mPostReference.updateChildren(childUpdates);
        }
    }






 */




}

