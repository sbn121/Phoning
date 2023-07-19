package com.example.lastcloneappproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivityFindPwBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.UUID;

public class FindPwActivity extends AppCompatActivity {

    ActivityFindPwBinding binding;

    String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFindPwBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        Intent intent = getIntent();
        binding.edtEmail.setText(intent.getStringExtra("email"));

        binding.imgvNext.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "checkEmail");
            conn.addParamMap("email", binding.edtEmail.getText().toString());
            conn.onExcute((isResult, data) -> {
                PhoningVO vo = new Gson().fromJson( data, new TypeToken< PhoningVO >(){}.getType() );
                if(vo!=null){
                    pw = UUID.randomUUID().toString();
                    pw = pw.substring( pw.lastIndexOf("-")+1 );

                    CommonConn conn1 = new CommonConn(this, "update");
                    conn1.addParamMap("email", binding.edtEmail.getText().toString());
                    conn1.addParamMap("pw", pw);
                    conn1.onExcute((isResult1, data1) -> {
                        if(data1.equals("성공")){
                            binding.tvNewPw.setText(pw);
                            binding.tvPw.setVisibility(View.VISIBLE);
                            binding.rlPw.setVisibility(View.VISIBLE);
                            binding.imgvNext.setVisibility(View.GONE);
                            binding.imgvCopy.setOnTouchListener(new View.OnTouchListener(){ //터치 이벤트 리스너 등록(누를때)
                                @Override
                                public boolean onTouch(View v, MotionEvent event) {
                                    if(event.getAction()==MotionEvent.ACTION_DOWN){ //눌렀을 때 동작
                                        //클립보드 사용 코드
                                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                                        ClipData clipData = ClipData.newPlainText("비밀번호", binding.tvNewPw.getText().toString()); //클립보드에 ID라는 이름표로 id 값을 복사하여 저장
                                        clipboardManager.setPrimaryClip(clipData);
                                        if(clipData!=null){
                                            Toast.makeText(FindPwActivity.this, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    return true;
                                }
                            });
                        }else {

                        }
                    });
                }else {
                    Toast.makeText(this, "존재하지 않는 계정입니다.\n새 계정을 생성해주세요.", Toast.LENGTH_LONG).show();
                }
            });
        });

    }



}