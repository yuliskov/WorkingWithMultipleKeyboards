package org.samples.keyboardmanager.keyboards;

import android.content.Context;
import android.support.annotation.Nullable;

import org.samples.keyboardmanager.addons.AddOn;
import org.samples.keyboardmanager.addons.AddOnImpl;

public class KeyboardAddOnAndBuilder extends AddOnImpl {

    public static final String KEYBOARD_PREF_PREFIX = "keyboard_";

    private final int mResId;
    private final int mLandscapeResId;
    //private final int mIconResId;
    private final String mDefaultDictionary;
    private final int mQwertyTranslationId;
    private final String mAdditionalIsLetterExceptions;
    private final String mSentenceSeparators;
    private final boolean mKeyboardDefaultEnabled;
    private final String mKeyboardDescription;

    public KeyboardAddOnAndBuilder(Context askContext, Context packageContext, String id, int nameResId,
                                   int layoutResId, int landscapeLayoutResId,
                                   String defaultDictionary, String keyboardDescription, int iconResId,
                                   int physicalTranslationResId,
                                   String additionalIsLetterExceptions,
                                   String sentenceSeparators,
                                   String description,
                                   int keyboardIndex,
                                   boolean keyboardDefaultEnabled) {
        super(askContext, packageContext, KEYBOARD_PREF_PREFIX + id, nameResId, description, keyboardIndex);

        mResId = layoutResId;
        if (landscapeLayoutResId == AddOn.INVALID_RES_ID) {
            mLandscapeResId = mResId;
        } else {
            mLandscapeResId = landscapeLayoutResId;
        }

        mDefaultDictionary = defaultDictionary;
        mKeyboardDescription = keyboardDescription;
        //mIconResId = iconResId;
        mAdditionalIsLetterExceptions = additionalIsLetterExceptions;
        mSentenceSeparators = sentenceSeparators;
        mQwertyTranslationId = physicalTranslationResId;
        mKeyboardDefaultEnabled = keyboardDefaultEnabled;
    }

    public boolean getKeyboardDefaultEnabled() {
        return mKeyboardDefaultEnabled;
    }

    public String getKeyboardLocale() {
        return mDefaultDictionary;
    }

    public String getKeyboardDescription() {
        return mKeyboardDescription;
    }

    public String getSentenceSeparators() {
        return mSentenceSeparators;
    }

    @Nullable
    public android.inputmethodservice.Keyboard createKeyboard() {
        Context remoteContext = getPackageContext();
        if (remoteContext == null) return null;
        return new android.inputmethodservice.Keyboard(remoteContext, mLandscapeResId);
    }

    //@Nullable
    //public android.inputmethodservice.Keyboard createKeyboard(Context askContext, @Keyboard.KeyboardRowModeId int mode) {
    //    Context remoteContext = getPackageContext();
    //    if (remoteContext == null) return null;
    //    return new ExternalAnyKeyboard(this, askContext, remoteContext, mResId, mLandscapeResId, getId(), getName(), mIconResId, mQwertyTranslationId, mDefaultDictionary, mAdditionalIsLetterExceptions, mSentenceSeparators, mode);
    //}
}
