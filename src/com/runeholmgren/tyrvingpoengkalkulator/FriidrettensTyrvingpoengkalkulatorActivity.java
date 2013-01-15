package com.runeholmgren.tyrvingpoengkalkulator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
	FrameLayout buttonFrame;
	LinearLayout mainlinearlayout;
	RelativeLayout relativeLayout;
	Display display;
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button button_comma;
	Button button_help;
	
	TyrvingConstants tyrving_constants = new TyrvingConstants();
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	setTheme(android.R.style.Theme_Black);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        input_result = (EditText) findViewById(R.id.input_result);
        input_result.setHint("Skriv inn resultatet");
        input_result.setFocusable(false);
        
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
        
        buttonFrame = (FrameLayout)findViewById(R.id.frameLayout1);
        mainlinearlayout = (LinearLayout)findViewById(R.id.mainlinearlayout);
        display = getWindowManager().getDefaultDisplay();
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout1);
        
        button1 = (Button)findViewById(R.id.button8);
        button2 = (Button)findViewById(R.id.button4);
        button3 = (Button)findViewById(R.id.button13);
        button4 = (Button)findViewById(R.id.button7);
        button5 = (Button)findViewById(R.id.button3);
        button6 = (Button)findViewById(R.id.button12);
        button7 = (Button)findViewById(R.id.button6);
        button8 = (Button)findViewById(R.id.button2);
        button9 = (Button)findViewById(R.id.button11);
        button0 = (Button)findViewById(R.id.button1);
        button_comma = (Button)findViewById(R.id.button5);
        button_help = (Button)findViewById(R.id.button9);
        
        button0.setText("0");
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        button8.setText("8");
        button9.setText("9");
        button_comma.setText(",");
        button_help.setText("backspace");
        
        int buttonWidth = display.getWidth()/3;
        int buttonHeight = buttonFrame.getHeight();
        
        
        button0.setWidth(buttonWidth);
        button0.setHeight(buttonHeight);
        button1.setWidth(buttonWidth);
        button1.setHeight(buttonHeight);
        button2.setWidth(buttonWidth);
        button2.setHeight(buttonHeight);
        button3.setWidth(buttonWidth);
        button3.setHeight(buttonHeight);
        button4.setWidth(buttonWidth);
        button4.setHeight(buttonHeight);        
        button5.setWidth(buttonWidth);
        button5.setHeight(buttonHeight);
        button6.setWidth(buttonWidth);
        button6.setHeight(buttonHeight);
        button7.setWidth(buttonWidth);
        button7.setHeight(buttonHeight);
        button8.setWidth(buttonWidth);
        button8.setHeight(buttonHeight);
        button9.setWidth(buttonWidth);
        button9.setHeight(buttonHeight);
        button_comma.setWidth(buttonWidth);
        button_comma.setHeight(buttonHeight);
        button_help.setWidth(buttonWidth);
        button_help.setHeight(buttonHeight);
        
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
        button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"0");
			}
		});
        button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"1");
			}
		});
        button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"2");
			}
		});
        button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"3");
			}
		});
        button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"4");
			}
		});
        button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"5");
			}
		});
        button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"6");
			}
		});
        button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"7");
			}
		});
        button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"8");
			}
		});
        button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+"9");
			}
		});
        button_comma.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				input_result.setText(input_result.getText()+",");
			}
		});
        button_help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String temp_input = "";
				for(int i=0;i<input_result.getText().length()-1;i++){
					temp_input += input_result.getText().charAt(i);
				}
				input_result.setText(temp_input);
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