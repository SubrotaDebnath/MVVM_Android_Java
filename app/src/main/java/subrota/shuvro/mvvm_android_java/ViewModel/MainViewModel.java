package subrota.shuvro.mvvm_android_java.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private String TAG = "MainViewModel";

    public String inputString(String value, String inputString){
        Log.i(TAG, "input String= " + inputString);
        if (value.equals("=")){
            inputString = inputString;
        }else if (value.equals("c")){
            inputString = "";
        }else if (value.equals("b")){
            inputString = backOperation(inputString);
        }else {
            inputString = inputString+value;
        }
        return inputString;
    }

    private String backOperation(String inputString){
        Log.i(TAG, "input String trim= " + inputString);
        if (inputString != null && inputString.length() > 0 ) {
            inputString = inputString.substring(0, inputString.length() - 1);
        }else {
            inputString = "";
        }
        return inputString;
    }

    private String add(String totalValue, String lastValue){
        int sum = Integer.valueOf(totalValue) + Integer.valueOf(lastValue);
        return String.valueOf(sum);
    }

}
