package charlesroger.informanet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Charles Roger on 11/07/2018.
 */

public class DepannageDetails extends AppCompatActivity  {

    private Depannage depannage;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depannage_view);
        this.depannage = (Depannage) getIntent().getSerializableExtra("Depannage");

        final TextView clientName = findViewById(R.id.textViewClientName);
        final TextView clientTelephone = findViewById(R.id.textViewTelephoneClient);
        final TextView clientAdresse = findViewById(R.id.textViewAdresseClient);

        final TextView ordinateur = findViewById(R.id.textViewOrdinateur);
        final TextView intervenant = findViewById(R.id.textViewIntervenant);
        final TextView titre = findViewById(R.id.detailTitle);
        final TextView description = findViewById(R.id.textViewDescription);
        final TextView date = findViewById(R.id.textViewDate);

        clientName.setText(depannage.getNomClient());
        clientTelephone.setText(depannage.getTelephoneClient());
        clientAdresse.setText(depannage.getAdresseClient());

        ordinateur.setText(depannage.getOrdinateur());
        intervenant.setText(depannage.getIntervenant());
        titre.setText(depannage.getTitre());
        description.setText(depannage.getDescription());
        date.setText(depannage.getDate());
    }
}
