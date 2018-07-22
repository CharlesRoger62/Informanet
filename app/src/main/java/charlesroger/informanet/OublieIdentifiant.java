package charlesroger.informanet;

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
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Charles Roger on 13/07/2018.
 */

public class OublieIdentifiant extends AppCompatActivity {

    public static final String TAG = OublieIdentifiant.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten);

        final EditText emailEdit = findViewById(R.id.editNewEmail);
        final Button envoyer = findViewById(R.id.buttonSendNewUser);

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Email sent.");
                                }
                            }
                        });
                Intent intentLogin = new Intent(OublieIdentifiant.this, MainActivity.class);
                startActivity(intentLogin);
            }
        });

    }
}
