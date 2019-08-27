package hridoy.aiz.fragmentswithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListner {

    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;
    public int flag = 0;

    String nameText, telephoneText, addWarningText, addSuccessText;
    Boolean addWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
        btnAdd = findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

        addWarningText = "";
        addSuccessText = "Added";
        addWarning = false;


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("LLL0 etName",etName.getText().toString());
                Log.d("LLL0 etTel",etTel.getText().toString());

                nameText = etName.getText().toString();
                telephoneText = etTel.getText().toString();

                Log.d("LLL1 nameText",nameText);
                Log.d("LLL1 telephoneText",telephoneText);

                if  (nameText.isEmpty() && telephoneText.isEmpty()) {
                    addWarningText = "Fill all the fields";
                    addWarning = true;
                } else if (telephoneText.isEmpty()) {
                    addWarningText = "Enter Telephone !";
                    addWarning = true;

                } else if (nameText.isEmpty()) {
                    addWarningText = "Enter Name!";
                    addWarning = true;


                }   else {
                    //default
                }


                if (addWarning) {
                    Toast.makeText(getApplicationContext(), addWarningText, Toast.LENGTH_LONG).show();
                } else {
                    Person p = new Person(nameText, telephoneText);
                    ApplicationClass.personArrayList.add(p);
                    Toast.makeText(getApplicationContext(), addSuccessText, Toast.LENGTH_LONG).show();
                    listFrag.notifyDataChanged();
                }

                etName.setText(null);
                etTel.setText(null);
                nameText="";
                telephoneText="";

                addWarningText = "";
                addWarning = false;

            }
        });

        onItemClick(0);
    }

    @Override
    public void onItemClick(int i) {
        //Toast.makeText(this,String.valueOf(i),Toast.LENGTH_SHORT).show();
        tvName.setText(ApplicationClass.personArrayList.get(i).getName());
        tvTel.setText(ApplicationClass.personArrayList.get(i).getTelephoneNumber());
    }
}
