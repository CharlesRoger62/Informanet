package charlesroger.informanet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Charles Roger on 11/07/2018.
 */

public class DepannageDetails extends AppCompatActivity  {

    private Depannage myDepannage;
    private String id;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depannage_view);
        id = (String)  getIntent().getSerializableExtra("Depannage");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Depannage");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for ( DataSnapshot datasnapshotDepannage : dataSnapshot.getChildren()) {
                    Depannage depannage = datasnapshotDepannage.getValue(Depannage.class);
                    if ( depannage.getId() == id ) {
                        myDepannage = depannage;
                        break;
                    }

                }
                if ( myDepannage == null ) {
                    Intent intent = new Intent(DepannageDetails.this, DepannageList.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        final TextView clientName = findViewById(R.id.textViewClientName);
        final TextView clientTelephone = findViewById(R.id.textViewTelephoneClient);
        final TextView clientAdresse = findViewById(R.id.textViewAdresseClient);

        final TextView ordinateur = findViewById(R.id.textViewOrdinateur);
        final TextView intervenant = findViewById(R.id.textViewIntervenant);
        final TextView titre = findViewById(R.id.detailTitle);
        final TextView description = findViewById(R.id.textViewDescription);
        final TextView date = findViewById(R.id.textViewDate);

        clientName.setText(myDepannage.getNomClient());
        clientTelephone.setText(myDepannage.getTelephoneClient());
        clientAdresse.setText(myDepannage.getAdresseClient());

        ordinateur.setText(myDepannage.getOrdinateur());
        intervenant.setText(myDepannage.getIntervenant());
        titre.setText(myDepannage.getTitre());
        description.setText(myDepannage.getDescription());
        date.setText(myDepannage.getDate());
    }
}
