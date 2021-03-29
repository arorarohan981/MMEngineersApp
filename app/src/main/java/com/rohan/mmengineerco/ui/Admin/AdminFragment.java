package com.rohan.mmengineerco.ui.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohan.mmengineerco.R;
import com.rohan.mmengineerco.ui.gallery.GalleryViewModel;

public class AdminFragment extends Fragment {
    private AdminViewModel adminViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView tv2;
        EditText editText1, editText2;
        AlertDialog.Builder build;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
         FirebaseAuth mAuth;
         ProgressDialog loadingbar;
        FirebaseUser currentuser;

        adminViewModel =
                new ViewModelProvider(this).get(AdminViewModel.class);
        View root = inflater.inflate(R.layout.activity_admin_panel, container, false);
        tv2 = (TextView) root.findViewById(R.id.textView1);
        editText1 = (EditText) root.findViewById(R.id.editText2);
        editText2 = (EditText) root.findViewById(R.id.editText3);
        build = new AlertDialog.Builder(getActivity());
        loadingbar = new ProgressDialog(getActivity());
//        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        currentuser=mAuth.getCurrentUser();

        Button loginbtn=root.findViewById(R.id.loginbutton);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int str = editText2.getText().toString().length();
                String email = editText1.getText().toString();
                String password = editText2.getText().toString();


                if (editText1.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter the email address", Toast.LENGTH_LONG).show();
                } else {
                    if (editText2.getText().toString().isEmpty()) {
                        Toast.makeText(getActivity().getApplicationContext(), "Please enter the password", Toast.LENGTH_LONG).show();
                    } else {
                        if (!editText1.getText().toString().trim().matches(emailPattern)) {
                            Toast.makeText(getActivity().getApplicationContext(), "Please enter valid email address", Toast.LENGTH_SHORT).show();
                        } else {
                            if (str < 6) {
                                Toast.makeText(getActivity().getApplicationContext(), "Please enter at least 6 digit password", Toast.LENGTH_LONG).show();
                            } else {
                                loadingbar.setTitle("Signing in");
                                loadingbar.setMessage("please wait....");
                                loadingbar.setCanceledOnTouchOutside(true);
                                loadingbar.show();
                                mAuth.signInWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    sendusertomainactivity();

                                                    loadingbar.dismiss();
                                                } else {
                                                    Toast.makeText(getActivity().getApplicationContext(), "Error: Wrong credentials" , Toast.LENGTH_SHORT).show();
                                                    loadingbar.dismiss();
                                                }
                                            }

                                            private void sendusertomainactivity() {
//                                                Intent intent = new Intent(getActivity().getApplicationContext(), AdminProductActivity.class);
//                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                                startActivity(intent);
//                                                finish();
                                            }
                                        });

                            }


                        }
                    }
                }
            }
        });
//        final TextView textView = root.findViewById(R.id.about_us_text);
//        final TextView textView=root.findViewById(R.id.about_us_text);
//        adminViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
