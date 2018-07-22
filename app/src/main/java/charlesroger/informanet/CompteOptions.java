package charlesroger.informanet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Charles Roger on 16/07/2018.
 */

public class CompteOptions extends AppCompatActivity {

    public DatabaseReference myRef;
    private StorageReference avatarRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_compte);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = mAuth.getCurrentUser();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Utilisateurs");

        final ArrayList listUtilisateur = new ArrayList<Utilisateur>();
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

        final EditText editCompteName = findViewById(R.id.editCompteName);
        final EditText editCompteSociete = findViewById(R.id.editCompteSociete);
        final EditText editCompteTelephone = findViewById(R.id.editCompteTel);

        editCompteName.setText(getIntent().getExtras().getString("UtilisateurNom"));
        editCompteSociete.setText(getIntent().getExtras().getString("UtilisateurSociete"));
        editCompteTelephone.setText(getIntent().getExtras().getString("UtilisateurTelephone"));

        Button saveButton = (Button) findViewById(R.id.buttonCompteModif);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilisateur myUtilisateur = new Utilisateur("Nothing","Nothing","Nothing",currentUser.getEmail());
                for ( Object objet: listUtilisateur ) {
                    Utilisateur user = (Utilisateur) objet;
                    if (user.getEmail().equals(currentUser.getEmail())) {
                        myUtilisateur.setSociete(user.getSociete());
                        myUtilisateur.setNom(user.getNom());
                        myUtilisateur.setTelephone(user.getTelephone());
                        myUtilisateur.setEmail(user.getEmail());
                    }
                }
                Utilisateur modifUtilisateur = new Utilisateur(myUtilisateur.getNom(),myUtilisateur.getSociete(),myUtilisateur.getTelephone(),myUtilisateur.getEmail());
                modifUtilisateur.setNom(editCompteName.getText().toString());
                modifUtilisateur.setSociete(editCompteSociete.getText().toString());
                modifUtilisateur.setTelephone(editCompteTelephone.getText().toString());

                FirebaseDatabase myData = FirebaseDatabase.getInstance();
                DatabaseReference myRef = myData.getReference().child("Utilisateurs").child(modifUtilisateur.getEmail());
                myRef.setValue(modifUtilisateur);

                Intent intent = new Intent(CompteOptions.this, DepannageList.class);
                startActivity(intent);
            }
        });

        avatarRef = FirebaseStorage.getInstance().getReference().child("Avatar");
    }

}
