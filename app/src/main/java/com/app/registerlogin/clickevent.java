package com.app.registerlogin;

import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class clickevent extends Activity implements View.OnClickListener {
    private Object FriendFrag;

//클릭 이벤트를 사용하려면 implements OnClickListener를 사용해야한다.



    @Override
    public void onClick(View v) {

        //super.onCreate(FriendFrag);


        //xml화면이 보여지게됨

        setContentView(R.layout.frag_friend);


        //이벤트 구현의 대상이 되는 위젯을 명시하기

        Button btn1 = (Button) findViewById(R.id.action_friend);


        //버튼 클릭시 이벤트 발생

        btn1.setOnClickListener(this);

    }
}
