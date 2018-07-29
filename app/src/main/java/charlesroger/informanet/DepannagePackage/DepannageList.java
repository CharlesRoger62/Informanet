package charlesroger.informanet.DepannagePackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import charlesroger.informanet.CompteOptions;
import charlesroger.informanet.Login.MainActivity;
import charlesroger.informanet.R;
import charlesroger.informanet.Utilisateur;

import static java.security.AccessController.getContext;

/**
 * Created by Charles Roger on 14/07/2018.
 */

public class DepannageList extends AppCompatActivity {

    final ArrayList listUtilisateur = new ArrayList();
    private ArrayList<DepannageBis> depannages;
    DepannageAdapter mAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_depannage_liste);
        depannages = new ArrayList<>();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Depannage");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    DepannageBis depannageBis = postSnapshot.getValue(DepannageBis.class);
                    depannages.add(depannageBis);



                }
                mAdapter = new DepannageAdapter(depannages);
                setupRecyclerView();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        /*
        List<Depannage> DepannageList = generateDepannageList();
        DepannageAdapter adapter = new DepannageAdapter(getContext(), );
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        */



    }



    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {





        return super.onCreateView(name, context, attrs);
    }
    private void setupRecyclerView() {


        RecyclerView recyclerView = findViewById(R.id.incidentView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);





    }







}
