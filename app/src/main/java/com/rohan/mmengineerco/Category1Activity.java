package com.rohan.mmengineerco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.rohan.mmengineerco.Model.Products;
import com.rohan.mmengineerco.ViewHolder.ProductViewHolder;
import com.squareup.picasso.Picasso;

public class Category1Activity extends AppCompatActivity {
    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String CategoryName, SearchInput;
    private FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);
        CategoryName = getIntent().getExtras().get("category").toString();
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(CategoryName);
        recyclerView = findViewById(R.id.recycler_menu1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (CategoryName.equals("Fire_Extinguisher")) {
            getSupportActionBar().setTitle("Fire Extinguisher");
        } else {
            if (CategoryName.equals("Fire_Extinguisher_Parts")) {
                getSupportActionBar().setTitle("Fire Extinguisher Parts");
            } else {
                if (CategoryName.equals("Fire_Hoses")) {
                    getSupportActionBar().setTitle("Fire Hoses");
                } else {
                    if (CategoryName.equals("Fire_Pumps")) {
                        getSupportActionBar().setTitle("Fire Pumps");
                    } else {
                        if (CategoryName.equals("Valves")) {
                            getSupportActionBar().setTitle("Valves");
                        } else {
                            if (CategoryName.equals("Sprinkler_System")) {
                                getSupportActionBar().setTitle("Sprinkler System");
                            } else {
                                if (CategoryName.equals("Monitors")) {
                                    getSupportActionBar().setTitle("Monitors");
                                } else {
                                    if (CategoryName.equals("Nozzles")) {
                                        getSupportActionBar().setTitle("Nozzles");
                                    } else {
                                        if (CategoryName.equals("Cabinets")) {
                                            getSupportActionBar().setTitle("Cabinets");
                                        } else {
                                            if (CategoryName.equals("Stands_Post_Hydrants")) {
                                                getSupportActionBar().setTitle("Stands Post Hydrants");
                                            } else {
                                                if (CategoryName.equals("Couplings_and_Adapters")) {
                                                    getSupportActionBar().setTitle("Couplings and Adapters");
                                                } else {
                                                    if (CategoryName.equals("Dry_Riser_Equipments")) {
                                                        getSupportActionBar().setTitle("Dry Riser Equipments");
                                                    } else {
                                                        if (CategoryName.equals("Hose_Reel")) {
                                                            getSupportActionBar().setTitle("Hose Reel");
                                                        } else {
                                                            if (CategoryName.equals("Safety_Items")) {
                                                                getSupportActionBar().setTitle("Safety Items");
                                                            } else {
                                                                getSupportActionBar().setTitle(CategoryName);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsRef, Products.class)
                        .build();


        adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Products model)
                    {
                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
//                        holder.txtProductPrice.setText("Price = " + "Rs " + model.getPrice());
                        Picasso.with(getApplicationContext()).load(model.getImage()).into(holder.imageView);
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(getApplicationContext(),ProductDetailsActivity.class);
                                intent.putExtra("pid",model.getPid());
                                intent.putExtra("category",CategoryName);
                                startActivity(intent);
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_items_activity, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        final MenuItem search = menu.findItem(R.id.searchitem);
        final SearchView searchView = (SearchView) search.getActionView();
        searchView.setQueryHint("Search your items here...");
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    fbsearch(query);
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    fbsearch(newText);
                    return false;
                }
            });
        }
        return true;
    }

    private void fbsearch (String searchText) {
        String pquery = searchText.toUpperCase();
        Query sQuery = ProductsRef.orderByChild("pname").startAt(pquery).endAt(pquery + "\uf8ff");
        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(sQuery, Products.class).setLifecycleOwner(this).build();
        adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Products model) {
                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
//                        holder.txtProductPrice.setText("Price = " + "Rs " + model.getPrice());
                        Picasso.with(getApplicationContext()).load(model.getImage()).into(holder.imageView);
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                                intent.putExtra("pid", model.getPid());
                                intent.putExtra("category", CategoryName);
                                startActivity(intent);
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_items_activity, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
