package com.example.user.testapf;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main1 extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.koko)).setText("fffff");
        int fds = 0;
        String gfds = "fds";
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Main1.this, Main2.class));
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        int fds = 0;
        String gfds = "fds";
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        int fds = 0;
        String gfds = "fds";
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        int fds = 0;
        String gfds = "fds";
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        int fds = 0;
        String gfds = "fds";
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        int fds = 0;
        String gfds = "fds";
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        int fds = 0;
        String gfds = "fds";
    }
}
