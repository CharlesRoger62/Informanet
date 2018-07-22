package charlesroger.informanet.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import charlesroger.informanet.R;

/**
 * Created by user on 16/07/2018.
 */

public class NewUser extends AppCompatActivity {

    public static final String TAG = OublieIdentifiant.class.getSimpleName();
    public String email;
    public String motDePasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        final EditText emailEdit = findViewById(R.id.editNewEmail);
        final EditText mdpEdit = findViewById(R.id.editTextNewMdp);
        final Button envoyer = findViewById(R.id.buttonSendNewUser);
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();


        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEdit.getText().toString();
                motDePasse = mdpEdit.getText().toString();
                mAuth.signInWithEmailAndPassword(email, motDePasse)
                        .addOnCompleteListener(NewUser.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(NewUser.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, motDePasse);
                                    Intent intent = new Intent(NewUser.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            }
        });

    }
}
