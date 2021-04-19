package sg.edu.rp.c346.id19030019.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1,spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String>aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1=findViewById(R.id.spinner1);
        spn2=findViewById(R.id.spinner2);
        btnUpdate=findViewById(R.id.buttonUpdate);

        alNumbers=new ArrayList<>();
        String[] strNumbers=getResources().getStringArray(R.array.even_numbers);
        alNumbers.addAll(Arrays.asList(strNumbers));

        aaNumbers=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn2.setAdapter(aaNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //approach 2
                alNumbers.clear();
                if(position==0){
                    String[] strNumbers=getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }else{
                    String[] strNumbers=getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=spn1.getSelectedItemPosition();
                alNumbers.clear();

                if(position==0){
                    String[] strNumbers=getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
    }
                aaNumbers.notifyDataSetChanged();

}
        });


    }
}