package com.runeholmgren.tyrvingpoengkalkulator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FriidrettensTyrvingpoengkalkulatorActivity extends Activity {
    /** Called when the activity is first created. */
	AppInput appInput = new AppInput();
	Spinner spinner_class;
	Spinner spinner_event;
	EditText input_result;
	TextView result_output;
	TextView result_string_output;
	Calculator calculator = new Calculator();
	TyrvingConstants tyrving_constants = new TyrvingConstants();
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	setTheme(android.R.style.Theme_Black);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        input_result = (EditText) findViewById(R.id.input_result);
        input_result.setHint("Skriv inn resultatet");
        
        spinner_class = (Spinner) findViewById(R.id.spinner_class);
        ArrayAdapter adapter_class = ArrayAdapter.createFromResource(
                this, R.array.pick_class, android.R.layout.simple_spinner_item);
        adapter_class.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_class.setAdapter(adapter_class);
        
        spinner_event = (Spinner) findViewById(R.id.spinner_event);
        ArrayAdapter adapter_event = ArrayAdapter.createFromResource(
                this, R.array.pick_event, android.R.layout.simple_spinner_item);
        adapter_event.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_event.setAdapter(adapter_event);
        
        result_output = (TextView)findViewById(R.id.result_output);
        
        result_string_output = (TextView)findViewById(R.id.result_string_output);
        
        loadConstants();

        spinner_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                newInput();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_event.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                newInput();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        input_result.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable s) {
				newInput();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
        });
        
        
        //ArrayAdapter adapter_class2 = ArrayAdapter.createFromResource(
        //        this, R.array.pick_class, android.R.layout.simple_spinner_item);
        //adapter_class2.getItem(0);
        
        
    }

    private void newInput(){
    	
    	appInput.interpretInput(spinner_class.getSelectedItemPosition(), spinner_event.getSelectedItemPosition(), "" + input_result.getText());
    	int score = calculator.calculateScore(appInput.getResult(), appInput.getEvent(), appInput.getPickedClass(), tyrving_constants);
    	//calculator.calculateScore(result, event, p_class, constants)
    	if(score==-1){
    		result_output.setText(spinner_event.getSelectedItem() + " er ikke i tyrvingtabbelen for " + appInput.getPickedClass());
    		result_output.setTextSize(13);
    	} else {
    		result_output.setText(score + " Tyrvingpoeng" /*+ tyrving_constants.getConstant(appInput.getPickedClass(),appInput.getEvent())[0]*/);
    		result_output.setTextSize(30);
    	}
    	result_string_output.setText(appInput.getResultString());
    	double[] temp = tyrving_constants.getConstant(Class.G10, Event.l40);
    	
    	//ArrayAdapter adapter_class2 = ArrayAdapter.createFromResource(
        //        this, R.array.J10, android.R.layout.simple_spinner_item);
    	
    	//Toast toast = Toast.makeText(getApplicationContext(), appInput.getEvent() + " " + appInput.getPickedClass() + " " + appInput.getResult(),Toast.LENGTH_SHORT);
    	
    	String temp2 = "";
    	temp2 += "Restult: " + Integer.toString(appInput.getResult()) + "\n";
    	temp2 += "Class: " + appInput.getPickedClass().toString() + "\n";
    	temp2 += "Event: " + appInput.getEvent().toString() + "\n";
    	for(int i=0;i<5;i++) temp2 += " " + Double.toString(tyrving_constants.getConstant(appInput.getPickedClass(), appInput.getEvent())[i]);
    	
    	
    	//Toast toast = Toast.makeText(getApplicationContext(), temp2 ,Toast.LENGTH_LONG);
    	//toast.show();
    } 
    
    private void loadConstants() {
    	ArrayAdapter constants; 
    	constants = ArrayAdapter.createFromResource(this, R.array.G10, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G10); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G11, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G11); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G12, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G12); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G13, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G13); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G14, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G14); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G15, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G15); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G16, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G16); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G17, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G17); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G18, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G18); 
    	constants = ArrayAdapter.createFromResource(this, R.array.G19, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.G19); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J10, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J10); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J11, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J11); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J12, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J12); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J13, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J13); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J14, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J14); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J15, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J15); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J16, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J16); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J17, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J17); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J18, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J18); 
    	constants = ArrayAdapter.createFromResource(this, R.array.J19, android.R.layout.simple_spinner_item);
    	tyrving_constants.addClassConstants(constants, Class.J19);
    }
}