package com.carterswebs.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our view variables, and initialize from layout file.
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button  showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Fact and color.
                String newFact = mFactBook.getFact();
                int color = mColorWheel.getColor();

                // Update factLabel and button with new color and fact.
                relativeLayout.setBackgroundColor(color);
                factLabel.setText(newFact);
                showFactButton.setTextColor(color);
            }
        };

        showFactButton.setOnClickListener(listener);
       // Toast.makeText(FunFactsActivity.this, "Yay, our Activity was Created!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're Logging from the onCreate() method!");
    }
}
