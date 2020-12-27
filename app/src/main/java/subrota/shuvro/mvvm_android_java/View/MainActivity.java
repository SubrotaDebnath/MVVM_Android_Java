package subrota.shuvro.mvvm_android_java.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import subrota.shuvro.mvvm_android_java.R;
import subrota.shuvro.mvvm_android_java.ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private TextView inputTV, resultTV;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        inputTV = findViewById(R.id.inputText);
        resultTV = findViewById(R.id.resultText);
    }
    public void onKeyPress(View view) {
        switch(view.getId()){
            case R.id.dot:
                setInputString(".");
                //Log.i(TAG, "dot Taped");
                break;
            case R.id.clear_text:
                setInputString("c");
                break;
            case R.id.oneStepBack:
                setInputString("b");
                break;
            case R.id.divide:
                setInputString("%");
                break;
            case R.id.multiply:
                setInputString("x");
                break;
            case R.id.minus:
                setInputString("-");
                break;
            case R.id.plus:
                setInputString("+");
                break;
            case R.id.equal:
                setInputString("=");
                break;
            case R.id.zero:
                setInputString("0");
                break;
            case R.id.one:
                setInputString("1");
                break;
            case R.id.two:
                setInputString("2");
                break;
            case R.id.three:
                setInputString("3");
                break;
            case R.id.four:
                setInputString("4");
                break;
            case R.id.five:
                setInputString("5");
                break;
            case R.id.six:
                setInputString("6");
                break;
            case R.id.seven:
                setInputString("7");
                break;
            case R.id.eight:
                setInputString("8");
                break;
            case R.id.nine:
                setInputString("9");
                break;
         }
    }

    void calculation(String value, String operator){

    }

    void setInputString(String value){
        String fullString = inputTV.getText().toString();
        String inputShow = viewModel.inputString(value, fullString);
        if (inputShow.length()>0){
            inputTV.setText(inputShow);
        }else {
            inputTV.setText("");
        }
    }
}
