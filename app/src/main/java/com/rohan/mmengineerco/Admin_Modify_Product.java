package com.rohan.mmengineerco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.rohan.mmengineerco.Model.Products;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

public class Admin_Modify_Product extends AppCompatActivity {
    private static final int pic_id = 152;
    private Button ModifyProductButton, DeleteProductButton;
    private ImageView InputProductImage;
    private EditText InputProductName, InputProductDescription;
    private String ProductId, CategoryName;
    private ProgressDialog loadingbar;
    private Uri filepath;
    private DatabaseReference Rootreference;
    private StorageReference profileimgref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__modify__product);
        ModifyProductButton = (Button) findViewById(R.id.add_new_product1);
        DeleteProductButton = (Button) findViewById(R.id.delete_product);
        InputProductImage = (ImageView) findViewById(R.id.select_product_image1);
        InputProductName = (EditText) findViewById(R.id.product_name1);
        InputProductDescription = (EditText) findViewById(R.id.product_description1);
        Rootreference = FirebaseDatabase.getInstance().getReference();
        profileimgref = FirebaseStorage.getInstance().getReference().child("Product Images");
        ProductId = getIntent().getStringExtra("pid");
        CategoryName = getIntent().getStringExtra("category");
        getActionBar().setTitle(CategoryName);
        loadingbar = new ProgressDialog(this);
        InputProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(inti, pic_id);
            }
        });
        ModifyProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModifyProducts();
            }
        });
        DeleteProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteProducts();
            }
        });
    }

    private void DeleteProducts() {
        loadingbar.setTitle("Deleting");
        loadingbar.setMessage("Please wait....");
        loadingbar.setCanceledOnTouchOutside(false);
        loadingbar.show();
        Rootreference.child("Products").child(CategoryName).child(ProductId).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(getApplicationContext(),admin_product_activity.class);
                    startActivity(intent);
                    loadingbar.dismiss();
                    Toast.makeText(getApplicationContext(),"Product deleted successfully.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loadingbar.dismiss();
                    Toast.makeText(getApplicationContext(),"Error in deleting the product..",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void onStart() {
        loadingbar.setTitle("Loading");
        loadingbar.setMessage("please wait....");
        loadingbar.setCanceledOnTouchOutside(false);
        loadingbar.show();
        super.onStart();
        DatabaseReference Productref= FirebaseDatabase.getInstance().getReference().child("Products").child(CategoryName);
        Productref.child(ProductId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Products products=dataSnapshot.getValue(Products.class);
                    InputProductName.setText(products.getPname());
                    InputProductDescription.setText(products.getDescription());
                    Picasso.with(getApplicationContext()).load(products.getImage()).into(InputProductImage);
                    loadingbar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    private void ModifyProducts() {
        loadingbar.setTitle("Updating");
        loadingbar.setMessage("please wait....");
        loadingbar.setCanceledOnTouchOutside(false);
        loadingbar.show();
        final String name=InputProductName.getText().toString();
        final String description=InputProductDescription.getText().toString();
        Rootreference.child("Products").child(CategoryName).child(ProductId).child("pname").setValue(name);
        Rootreference.child("Products").child(CategoryName).child(ProductId).child("description").setValue(description)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(getApplicationContext(),admin_product_activity.class);
                            startActivity(intent);
                            loadingbar.dismiss();
                            Toast.makeText(getApplicationContext(),"Updated Successfully.",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            loadingbar.dismiss();
                            Toast.makeText(getApplicationContext(),"Error in updating product.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }




    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        if (resultcode == RESULT_OK && requestcode == pic_id && data != null) {
            filepath = data.getData();
            CropImage.activity(filepath)
                    .setAspectRatio(1,1)
                    .start(this);
        }

        if (requestcode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultcode == RESULT_OK) {
                final Uri resultUri = result.getUri();
                loadingbar.setTitle("Uploading");
                loadingbar.setMessage("Please wait while we are uploading the image.....");
                loadingbar.setCanceledOnTouchOutside(false);
                final StorageReference reference = profileimgref.child( ProductId + ".jpg");

                reference.putFile(resultUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Rootreference.child("Products").child(CategoryName).child(ProductId).child("image").setValue(String.valueOf(uri));
                                loadingbar.dismiss();
                                Toast.makeText(getApplicationContext(),"Image updated successfully...",Toast.LENGTH_SHORT).show();

                            }
                        });
                    } });


            }
        }
    }
}
