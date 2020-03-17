package hr.unidu.kz.primjeribiraca;

import android.os.Bundle;

import android.content.Intent;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NumberPicker np, tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obrada akcija izbornika opcija
        switch (item.getItemId()) {
            case R.id.izbor_datum:
                birajDatum();
                return true;
            case R.id.izbor_vrijeme:
                birajVrijeme();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void birajDatum(){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void birajVrijeme(){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }



}