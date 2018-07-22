package charlesroger.informanet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private FirebaseAuth mAuth;
    public static final String TAG = OublieIdentifiant.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button connexionButton = (Button) findViewById(R.id.buttonConnection);
        final EditText editEmail = findViewById(R.id.editEmail);
        final EditText editPassword = findViewById(R.id.editPassword);

        final ArrayList listUtilisateur = new ArrayList<Utilisateur>();
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

        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                mAuth = FirebaseAuth.getInstance();

                //AuthResult result = mAuth.signInWithEmailAndPassword(email, password).getResult();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Integer count = 0;
                                    String myEmail = user.getEmail();
                                    for(Object object : listUtilisateur){
                                        Utilisateur utilisateur = (Utilisateur) object;
                                        String utilisateurEmail = utilisateur.getEmail();
                                        if( utilisateurEmail.equals(myEmail)) {
                                            Intent intent = new Intent(MainActivity.this, DepannageList.class);
                                            startActivity(intent);
                                            intent.putExtra("UtilisateurNom",utilisateur.getNom());
                                            intent.putExtra("UtilisateurSociete",utilisateur.getSociete());
                                            intent.putExtra("UtilisateurTelephone",utilisateur.getTelephone());
                                            count++;
                                            break;
                                        }
                                    }
                                    if ( count == 0) {
                                        Utilisateur newUtilisateur = new Utilisateur("A completer", "A completer", "A completer", mAuth.getCurrentUser().getEmail());
                                        myRef.child(mAuth.getCurrentUser().getEmail()).setValue(newUtilisateur);
                                        Intent intent = new Intent(MainActivity.this, DepannageList.class);
                                        startActivity(intent);
                                    }
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            }
        });
        final TextView mdpOublie = findViewById(R.id.textViewMdpOubli);

        mdpOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOublie = new Intent(MainActivity.this, OublieIdentifiant.class);
                startActivity(intentOublie);
            }
        });
        final Button inscriptionButton = findViewById(R.id.InscriptionButton);

        inscriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewUser.class);
                startActivity(intent);
            }
        });
    }
}
