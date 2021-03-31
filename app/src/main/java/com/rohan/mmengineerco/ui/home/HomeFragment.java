package com.rohan.mmengineerco.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rohan.mmengineerco.Category1Activity;
import com.rohan.mmengineerco.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button fireextinguisher,fireextinguisherparts,firehoses,firepumps,valves,sprinklersystem,monitors,nozzles,cabinets,standsposthydrants,couplingandadapter,Dryriserequipment,hosereel,safetyitems;
    private FirebaseUser currentuser;
    private FirebaseAuth mAuth;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        fireextinguisher=root.findViewById(R.id.gotoFireExtinguisher);
        fireextinguisherparts=root.findViewById(R.id.gotoFireExtinguisherparts);
        firehoses=root.findViewById(R.id.gotoFireHose);
        firepumps=root.findViewById(R.id.gotoFirePump);
        valves=root.findViewById(R.id.gotoValves);
        sprinklersystem=root.findViewById(R.id.gotoSprinklerSystem);
        monitors=root.findViewById(R.id.gotoMonitors);
        nozzles=root.findViewById(R.id.gotoNozzles);
        cabinets=root.findViewById(R.id.gotoCabinets);
        standsposthydrants=root.findViewById(R.id.gotoStandsPostHydrants);
        couplingandadapter=root.findViewById(R.id.gotoCouplingsandAdapters);
        Dryriserequipment=root.findViewById(R.id.gotoDryRiserequipments);
        hosereel=root.findViewById(R.id.gotoHoseReel);
        safetyitems=root.findViewById(R.id.gotoSafetyItems);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        fireextinguisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Fire_Extinguisher");
                startActivity(intent);
            }
        });
        fireextinguisherparts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Fire_Extinguisher_Parts");
                startActivity(intent);
            }
        });
        firehoses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Fire_Hoses");
                startActivity(intent);
            }
        });
        firepumps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Fire_Pumps");
                startActivity(intent);
            }
        });
        valves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Valves");
                startActivity(intent);
            }
        });
        sprinklersystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Sprinkler_System");
                startActivity(intent);
            }
        });
        monitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Monitors");
                startActivity(intent);
            }
        });
        nozzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Nozzles");
                startActivity(intent);
            }
        });
        cabinets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Cabinets");
                startActivity(intent);
            }
        });
        standsposthydrants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Stands_Post_Hydrants");
                startActivity(intent);
            }
        });
        couplingandadapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Couplings_and_Adapters");
                startActivity(intent);
            }
        });
        Dryriserequipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Dry_Riser_Equipments");
                startActivity(intent);
            }
        });
        hosereel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Hose_Reel");
                startActivity(intent);
            }
        });
        safetyitems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Category1Activity.class);
                intent.putExtra("category", "Safety_Items");
                startActivity(intent);
            }
        });
        return root;

    }

}