package com.example.order_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductNameAndQRCode extends AppCompatActivity {

    // Define the pic id
    private static final int pic_id = 1001;
    private static int RESULT_LOAD_IMAGE = 1;
    Button New , Savebtn , PrintQR;
    TextView camera , gallary;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_name_and_qrcode);
        New = findViewById(R.id.btnNewProduct);
        Savebtn = findViewById(R.id.btnSaveProduct);
        PrintQR = findViewById(R.id.btnPrintQR);
        camera = findViewById(R.id.txtViewCamera);
        gallary = findViewById(R.id.txtViewGallary);
        imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.VISIBLE);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with camera_intent, and request pic id
                startActivityForResult(intent,pic_id);
            }
        });

        gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });

        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductNameAndQRCode.this,"New Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

        Savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductNameAndQRCode.this,ProductDetailsActivity.class));
            }
        });

        PrintQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductNameAndQRCode.this,"PrintQR Button Clicked" , Toast.LENGTH_SHORT).show();
            }
        });

    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            imageView.setImageBitmap(photo);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = { MediaStore.Images.Media.DATA };
//            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
//            cursor.moveToFirst();
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//        }
//    }
}