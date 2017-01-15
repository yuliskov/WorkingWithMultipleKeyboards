package org.samples.mainkeyboardapp;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.samples.keyboardmanager.KeyboardManager;
import org.samples.keyboardmanager.keyboards.KeyboardAddOnAndBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KeyboardManager keyboardManager = new KeyboardManager(this,
                "org.samples.langpack.KEYBOARD",
                "org.samples.langpack.keyboards");
        List<KeyboardAddOnAndBuilder> keyboards = keyboardManager.findAllKeyboardBuilders();

        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        for (KeyboardAddOnAndBuilder builder : keyboards) {
            TextView child = new TextView(this);
            child.setText(builder.getKeyboardLocale() + " " + builder.getKeyboardDescription());
            container.addView(child);
        }

        if (keyboards.size() == 0) {
            TextView child = new TextView(this);
            child.setText("You do not have any keyboards installed.");
            container.addView(child);
        }
    }
}
