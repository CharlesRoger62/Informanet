package charlesroger.informanet.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
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

import charlesroger.informanet.DepannagePackage.DepannageList;
import charlesroger.informanet.R;
import charlesroger.informanet.Utilisateur;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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


        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // TODO remettre system de login
                Intent intent = new Intent(getApplicationContext(), DepannageList.class);
                startActivity(intent);



                //AuthResult result = mAuth.signInWithEmailAndPassword(email, password).getResult();
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
