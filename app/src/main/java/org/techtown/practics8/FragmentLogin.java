package org.techtown.practics8;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class FragmentLogin extends Fragment {

    EditText editName;
    EditText editAge;
    Button editDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);

        editName = rootView.findViewById(R.id.name);
        editAge= rootView.findViewById(R.id.age);
        editDate = rootView.findViewById(R.id.date);
        Button button = rootView.findViewById(R.id.button);
        Date currentTime = Calendar.getInstance().getTime();
        editDate.setText(new SimpleDateFormat("YYYY/MM/dd", Locale.getDefault()).format(currentTime));

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener SetDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalendar.set(Calendar.YEAR, i);
                myCalendar.set(Calendar.MONTH, i1);
                myCalendar.set(Calendar.DAY_OF_MONTH, i2);

                String format = "YYYY/MM/dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
                editDate.setText(simpleDateFormat.format(myCalendar.getTime()));
            }
        };

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), SetDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(editAge.getText().toString());
                String name = editName.getText().toString();
                String date = editDate.getText().toString();
                Toast.makeText(getContext(), "나이: " + editAge+ ", 이름: "+ editName + ", 생년월일" + editDate, Toast.LENGTH_SHORT).show();
            }
        });




        return rootView;
    }
}