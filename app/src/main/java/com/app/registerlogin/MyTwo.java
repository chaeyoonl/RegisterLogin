package com.app.registerlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
    Button Button_send;
    Button Button_ext;
    DatabaseReference myRef;





    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_two);


        Button_send = findViewById(R.id.Button_send);
        Button_ext = findViewById(R.id.Button_ext);
        EditText_chat = findViewById(R.id.EditText_chat);
        EditText_player = findViewById(R.id.EditText_player);


        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();





        Button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = EditText_chat.getText().toString(); //msg
                String msg2 = EditText_player.getText().toString(); //msg

                if(msg != null) {
                    ChatData chat = new ChatData();
                    //ChatData chat2 = new ChatData();
                    chat.setNickname(nick);
                    //chat.setNickname(nick);
                    chat.setMsg(msg);
                    //myRef.push().setValue(chat);
                    chat.setMsg2(msg2);
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

