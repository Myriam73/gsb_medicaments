package fr.be2.gsb_medicaments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.security.SecureRandom;

public class authentification extends AppCompatActivity {
    private EditText CodeV, myKey;
    private Button btnValiderCodeV, btnValiderCle;
    LinearLayout layoutCle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        CodeV = findViewById(R.id.codeV);
        myKey = findViewById(R.id.myKey);
        layoutCle = findViewById(R.id.layoutCle);
        layoutCle.setVisibility(View.INVISIBLE);
    }

    public void AfficheLayout(View v){
        layoutCle.setVisibility(View.VISIBLE);
        String myRandomKey = genererChaineAleatoire(5);
        Log.d("APPLI", "myKey"+myRandomKey);
    }

    private String genererChaineAleatoire(int longueur) {
        String caracteresPermis = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder chaineAleatoire = new StringBuilder();

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < longueur; i++) {
            int index = random.nextInt(caracteresPermis.length());
            char caractereAleatoire = caracteresPermis.charAt(index);
            chaineAleatoire.append(caractereAleatoire);
        }

        return chaineAleatoire.toString();
    }
}