package com.rohan.mmengineerco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohan.mmengineerco.Model.Products;
import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {
//    private Button order;
    private ImageView ProductImage;
    private TextView ProductPrice, ProductName,ProductDescription;
    private String ProductId,CategoryName;
    private EditText Quantity,details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
//        order=(Button)findViewById(R.id.btn_order);
//        details=(EditText)findViewById(R.id.product_details);

        ProductImage=(ImageView)findViewById(R.id.product_image_details);

        ProductName=(TextView)findViewById(R.id.product_name_on_APD);
        ProductDescription=(TextView)findViewById(R.id.product_description_details);
        ProductId=getIntent().getStringExtra("pid");
        CategoryName=getIntent().getStringExtra("category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getProductDetails(ProductId);
    }

    public void openWhatsapponContactus(View view) {
        String ProductNameStr=ProductName.getText().toString();
        PackageManager pm = getPackageManager();
        try {


            String toNumber = "+91 9823113282"; // Replace with mobile phone number without +Sign or leading zeros, but with country code.
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            String text = "Hello !! I Would like to Enquire about  " +ProductNameStr+ " ( " +  ProductId + " ) ." ;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + text));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "It seems that Whatsapp is not installed in this Phone. ", Toast.LENGTH_LONG).show();

        }
    }
    private void getProductDetails(String productId) {
        DatabaseReference Productref= FirebaseDatabase.getInstance().getReference().child("Products").child(CategoryName);
        Productref.child(productId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Products products=dataSnapshot.getValue(Products.class);
                    ProductName.setText(products.getPname());
                    ProductDescription.setText(products.getDescription());
                    Picasso.with(getApplicationContext()).load(products.getImage()).into(ProductImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}