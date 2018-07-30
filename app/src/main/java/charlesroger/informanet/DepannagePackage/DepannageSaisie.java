package charlesroger.informanet.DepannagePackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import charlesroger.informanet.R;

/**
 * Created by Charles Roger on 11/07/2018.
 */

public class DepannageSaisie extends AppCompatActivity {

    private Depannage depannage;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire_depannage);

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        final Button saveButton = (Button) findViewById(R.id.saveButton);
        final EditText nameClient = findViewById(R.id.editNameClient);
        final EditText adresseClient = findViewById(R.id.editAdresseClient);
        final EditText telephoneClient = findViewById(R.id.editTelephoneClient);
        final EditText ordinateur = findViewById(R.id.editOrdinateur);
        final EditText titre = findViewById(R.id.editTitre);
        final EditText description = findViewById(R.id.editDescription);

        saveButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();

                // Permet de récupérer la date actuelle
                Date currentTime = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = df.format(currentTime);

                //Récupération des champs remplies par l'utilisateur

                String name = nameClient.getText().toString();
                String adresse = adresseClient.getText().toString();
                String telephone = telephoneClient.getText().toString();
                String ordinateurName = ordinateur.getText().toString();
                String titreName = titre.getText().toString();
                String descriptionName = description.getText().toString();
                String uniqueID = UUID.randomUUID().toString();

                depannage = new Depannage(uniqueID,"à venir",formattedDate,"Boulogne-sur-mer",name,adresse,telephone,titreName,ordinateurName,descriptionName,0);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();

                myRef.child("Depannage").child(uniqueID).setValue(depannage);

                Intent intent = new Intent(DepannageSaisie.this, DepannageList.class);
                startActivity(intent);

            }
        });
    }
}
