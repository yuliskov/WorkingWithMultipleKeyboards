package org.samples.keyboardmanager;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import org.samples.keyboardmanager.keyboards.KeyboardAddOnAndBuilder;
import org.samples.keyboardmanager.keyboards.KeyboardFactory;

import java.util.ArrayList;
import java.util.List;

public class KeyboardManager {
    private final Context mContext;
    private List<KeyboardAddOnAndBuilder> mKeyboardBuilders;
    private final KeyboardFactory mKeyboardFactory;

    public KeyboardManager(Context ctx, String receiverAction, String receiverMetaData) {
        mContext = ctx;
        mKeyboardFactory = new KeyboardFactory(receiverAction, receiverMetaData);
    }

    public List<KeyboardAddOnAndBuilder> findAllKeyboardBuilders() {
        return mKeyboardFactory.getAllAvailableKeyboards(mContext);
    }

    public List<Keyboard> findAllKeyboards() {
        mKeyboardBuilders = mKeyboardFactory.getAllAvailableKeyboards(mContext);
        List<Keyboard> keyboards = new ArrayList<>();
        if (!mKeyboardBuilders.isEmpty()) {
            for (KeyboardAddOnAndBuilder builder : mKeyboardBuilders) {
                keyboards.add(builder.createKeyboard());
            }
        }
        return keyboards;
    }
}
