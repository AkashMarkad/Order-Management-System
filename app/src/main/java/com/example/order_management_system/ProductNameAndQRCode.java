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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductNameAndQRCode extends AppCompatActivity {

    // Define the pic id
    private static final int pic_id = 1001;
    private static final int RESULT_LOAD_IMAGE = 1;
    Button New , Savebtn , PrintQR;
    TextView camera , gallery;
    ImageView imageView;

    EditText quantityValue , weightValue, lessWeightValue, addWeightValue, netWeightValue, saleLessWeightValue, itemSizeValue, hallMarkValue;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_name_and_qrcode);

        quantityValue = findViewById(R.id.quantityValue);
        weightValue = findViewById(R.id.weightValue);
        lessWeightValue = findViewById(R.id.lessWeightValue);
        addWeightValue = findViewById(R.id.addWeightValue);
        netWeightValue = findViewById(R.id.netWeightValue);
        saleLessWeightValue = findViewById(R.id.saleLessWeightValue);
        itemSizeValue = findViewById(R.id.itemSizeValue);
        hallMarkValue = findViewById(R.id.hallMarkValue);

        setContentView(R.layout.activity_product_name_and_qrcode);
        New = findViewById(R.id.btnNewProduct);
        Savebtn = findViewById(R.id.btnSaveProduct);
        PrintQR = findViewById(R.id.btnPrintQR);
        camera = findViewById(R.id.txtViewCamera);
        gallery = findViewById(R.id.txtViewGallery);
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

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, RESULT_LOAD_IMAGE);
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("scale", true);
                intent.putExtra("outputX", 500);
                intent.putExtra("outputY", 500);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, 1);
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

                String quantityVal = quantityValue.getText().toString().trim();
                String weightVal = weightValue.getText().toString().trim();
                String lessWeightVal = lessWeightValue.getText().toString().trim();
                String addWeightVal = addWeightValue.getText().toString().trim();
                String netWeightVal = netWeightValue.getText().toString().trim();
                String saleLessWeightVal = saleLessWeightValue.getText().toString().trim();
                String itemSizeVal = itemSizeValue.getText().toString().trim();
                String hallMarkVal = hallMarkValue.getText().toString().trim();

//                if(TextUtils.isEmpty(quantityVal)){
//                    quantityValue.setError("Please enter quantity value");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(weightVal)){
//                    weightValue.setError("Please enter weight");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(lessWeightVal)){
//                    lessWeightValue.setError("Please enter less weight value");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(addWeightVal)){
//                    addWeightValue.setError("Please enter add weight value");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(netWeightVal)){
//                    netWeightValue.setError("Please enter net weight value");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(saleLessWeightVal)){
//                    saleLessWeightValue.setError("Please enter sale less weight value");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(itemSizeVal)){
//                    itemSizeValue.setError("Please enter item size value");
//                    return ;
//                }
//                else if(TextUtils.isEmpty(hallMarkVal)){
//                    hallMarkValue.setError("Please enter hallMark value");
//                    return ;
//                }
//                else {
//                    startActivity(new Intent(ProductNameAndQRCode.this, ProductDetailsActivity.class));
//                }

                startActivity(new Intent(ProductNameAndQRCode.this , ProductDetailsActivity.class));
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

        if (requestCode == RESULT_LOAD_IMAGE ) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                //Get image
                Bitmap ProfilePic = extras.getParcelable("data");
                imageView.setImageBitmap(ProfilePic);
            }
        }
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}