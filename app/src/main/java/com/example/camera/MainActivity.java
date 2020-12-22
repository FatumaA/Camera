package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int picId = 1;

    Button openCam;
    ImageView displayPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCam = (Button)findViewById(R.id.openCam);
        displayPic = (ImageView)findViewById(R.id.displayPic);


        openCam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent cam_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cam_intent, picId);
            }
        });
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == picId) {

            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");
            displayPic.setImageBitmap(photo);
        }
    }


        //#TODO: add a delete option on the picture showing up in the image view and maybe a placeholder pic


}




