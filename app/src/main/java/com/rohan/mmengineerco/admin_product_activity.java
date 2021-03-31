package com.rohan.mmengineerco;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class admin_product_activity extends AppCompatActivity {
private Button fireextinguisher,fireextinguisherparts,firehoses,firepumps,valves,sprinklersystem,monitors,nozzles,cabinets,standsposthydrants,couplingandadapter,Dryriserequipment,hosereel,safetyitems;
    private FirebaseUser currentuser;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab= getSupportActionBar();
        ab.setTitle("Admin Page");
        setContentView(R.layout.activity_admin_product_activity);
        fireextinguisher=findViewById(R.id.ad_gotoFireExtinguisher);
        fireextinguisherparts=findViewById(R.id.ad_gotoFireExtinguisherparts);
        firehoses=findViewById(R.id.ad_gotoFireHose);
        firepumps=findViewById(R.id.ad_gotoFirePump);
        valves=findViewById(R.id.ad_gotoValves);
        sprinklersystem=findViewById(R.id.ad_gotoSprinklerSystem);
        monitors=findViewById(R.id.ad_gotoMonitors);
        nozzles=findViewById(R.id.ad_gotoNozzles);
        cabinets=findViewById(R.id.ad_gotoCabinets);
        standsposthydrants=findViewById(R.id.ad_gotoStandsPostHydrants);
        couplingandadapter=findViewById(R.id.ad_gotoCouplingsandAdapters);
        Dryriserequipment=findViewById(R.id.ad_gotoDryRiserequipments);
        hosereel=findViewById(R.id.ad_gotoHoseReel);
        safetyitems=findViewById(R.id.ad_gotoSafetyItems);
        fireextinguisher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Fire_Extinguisher");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Fire_Extinguisher");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        fireextinguisherparts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Fire_Extinguisher_Parts");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Fire_Extinguisher_Parts");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        firehoses.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Fire_Hoses");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Fire_Hoses");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        firepumps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Fire_Pumps");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Fire_Pumps");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        valves.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Valves");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Valves");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        sprinklersystem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Sprinkler_System");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Sprinkler_System");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        monitors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Monitors");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Monitors");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        nozzles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Nozzles");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Nozzles");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        cabinets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Cabinets");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Cabinets");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        standsposthydrants.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Stands_Post_Hydrants");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Stands_Post_Hydrants");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        couplingandadapter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Couplings_and_Adapters");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Couplings_and_Adapters");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        Dryriserequipment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Dry_Riser_Equipments");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Dry_Riser_Equipments");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        hosereel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Hose_Reel");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Hose_Reel");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        safetyitems.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CharSequence choices[]=new CharSequence[]
                        {
                                "Add new products in this category",
                                "Modify/Delete products from this category"
                        };
                AlertDialog.Builder builder=new AlertDialog.Builder(admin_product_activity.this);
                builder.setTitle("Select the option.");
                builder.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0)
                        {
                            Intent intent= new Intent(getApplicationContext(), Admin_Add_New_Product.class);
                            intent.putExtra("category", "Safety_Items");
                            startActivity(intent);
                        }
                        if(which==1)
                        {
                            Intent intent= new Intent(getApplicationContext(), admin_products_Category.class);
                            intent.putExtra("category", "Safety_Items");
                            startActivity(intent);
                        }

                    }
                });
                builder.show();
            }
        });
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.logout)
        {
            mAuth.signOut();
            sendusertomactivity();
        }

        return super.onOptionsItemSelected(item);
    }
    private void sendusertomactivity() {
        Intent intent = new Intent(getApplicationContext(),Navigation_Drawer_homescreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}