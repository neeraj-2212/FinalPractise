package com.example.finalpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class DetailsActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    private VideoView videoView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    Button back = findViewById(R.id.back);
        videoView = findViewById(R.id.videoView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(a);
            }
        });
        int videoResId = getIntent().getIntExtra("videoResId", 0);
        String videoTitle = getIntent().getStringExtra("videoTitle");
        setTitle(videoTitle);
        // Set the video resource to the VideoView
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + videoResId);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release the MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}