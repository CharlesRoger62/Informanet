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
    private ArrayList<Depannage> depannages;
    DepannageAdapter mAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton create = findViewById(R.id.fab);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepannageList.this, DepannageSaisie.class);
                startActivity(intent);
            }
        });


        setContentView(R.layout.fragment_depannage_liste);
        depannages = new ArrayList<>();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Depannage");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Depannage depannage = postSnapshot.getValue(Depannage.class);
                    depannages.add(depannage);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_depannage_list, menu);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Utilisateurs");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot datasnapshotUser : dataSnapshot.getChildren()) {
                    Utilisateur utilisateur = datasnapshotUser.getValue(Utilisateur.class);
                    listUtilisateur.add(utilisateur);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle extras = getIntent().getExtras();
        String utilisateurNom = "null";
        String utilisateurSociete = "null";
        String utilisateurTelephone = "null";
        if ( extras != null) {
            utilisateurNom = extras.getString("UtilisateurNom");
            utilisateurSociete = extras.getString("UtilisateurSociete");
            utilisateurTelephone = extras.getString("UtilisateurTelephone");
        }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
            case R.id.action_deconnexion:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(DepannageList.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.actionMonCompte:
                Intent intent1 = new Intent(DepannageList.this,CompteOptions.class);
                intent1.putExtra("UtilisateurNom",utilisateurNom);
                intent1.putExtra("UtilisateurSociete",utilisateurSociete);
                intent1.putExtra("UtilisateurTelephone",utilisateurTelephone);
                startActivity(intent1);
        }
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return DepannagePreviewFragment.newInstance(position + 1);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "A FAIRE";
                case 1:
                    return "EN COURS";
                case 2:
                    return "FAIT";
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }







}
