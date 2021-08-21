package com.tute04.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int Camera_REQUEST= 1888;
    ImageView imageView1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons and all other views must be redclared within this method like below
        //setOnClickListener method will only work in this method

        imageView1 = (ImageView) this.findViewById(R.id.imageView1);
        btn1=(Button)this.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, Camera_REQUEST);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == Camera_REQUEST){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView1.setImageBitmap(photo);
        }

    }
}