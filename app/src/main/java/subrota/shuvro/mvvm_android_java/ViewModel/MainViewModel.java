package subrota.shuvro.mvvm_android_java.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import subrota.shuvro.mvvm_android_java.View.MainActivity;

public class MainViewModel extends ViewModel {

    private String TAG = "MainViewModel";
    private String lastOperator;
    private double lastTotalValue;
    private double lastValue;

    public String inputString(String value, String inputString){
        Log.i(TAG, "input String= " + inputString);
        if (value.equals("=")){
            inputString = inputString;
        }else if (value.equals("c")){
            lastTotalValue = 0.0;
            lastValue = 0.0;
            lastOperator = "";
            inputString = "";
        }else if (value.equals("b")){
            inputString = backOperation(inputString);
        }else {
            inputString = inputString+value;
        }
        return inputString;
    }

    private String backOperation(String inputString){
        //Log.i(TAG, "input String trim= " + inputString);
        if (inputString != null && inputString.length() > 0 ) {
            inputString = inputString.substring(0, inputString.length() - 1);
        }else {
            inputString = "";
        }
        return inputString;
    }
    public void lastOperatorStore(String operator){
        lastOperator = operator;
    }
    public String calculation(double value){
        Log.i(TAG, "Value = " + value);
        if(lastOperator!= null){
            if (lastOperator.equals("+")){
                lastValue = (lastValue*10)+value;
                lastTotalValue = lastTotalValue+lastValue;
            }
        }else {
            lastTotalValue = (lastValue*10)+value;
        }

        Log.i(TAG, "lastTotalValue = " + lastTotalValue);
        return String.valueOf(lastTotalValue);
    }
}
