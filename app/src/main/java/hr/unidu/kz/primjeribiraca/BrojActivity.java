package hr.unidu.kz.primjeribiraca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by kruno on 14.10.16..
 */
public class BrojActivity extends AppCompatActivity {
    NumberPicker np, tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broj);
        // "klasičan" birač cijelih brojeva
        NumberPicker np = findViewById(R.id.numberPicker);
        final TextView tv = findViewById(R.id.izabrani);
        np.setMinValue(1);
        np.setMaxValue(100);
        // nakon što se izabere novi broj
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv.setText(String.valueOf(newVal));
            }
        });

        // birač koji ćemo napuniti nizovima znakova (bojama)
        tp = findViewById(R.id.textPicker);
        final TextView tb = findViewById(R.id.izBoja);
        final String[] boje= {"Crvena","Plava", "Smeđa", "Zelena", "Žuta"};
        // indeks prvog elementa polja boja
        tp.setMinValue(0);
        // indeks posljednjeg elementa polja boja
        tp.setMaxValue(boje.length-1);
        // Poveži NumberPicker s izvorom podatakau obliku polja boja
        tp.setDisplayedValues(boje);
        tp.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tb.setText(boje[newVal]);
            }
        });
    }

}
