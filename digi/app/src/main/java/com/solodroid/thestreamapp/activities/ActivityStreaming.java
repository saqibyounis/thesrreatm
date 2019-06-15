package com.solodroid.thestreamapp.activities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.solodroid.thestreamapp.R;

public class ActivityStreaming extends Activity implements OnPreparedListener {

    private long exitTime = 0;
    private VideoView videoView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_streaming);

        url = getIntent().getStringExtra("url");

        videoView = (VideoView) findViewById(R.id.video_view);
        videoView.setOnPreparedListener(this);

        Uri videoUri = Uri.parse(url);
        videoView.setVideoURI(videoUri);

    }

    @Override
    public void onPrepared() {
        //Starts the video playback as soon as it is ready
        videoView.start();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void closeStreaming() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, getString(R.string.press_again_to_close_streaming), Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

}
