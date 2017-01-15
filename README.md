#WorkingWithMultipleKeyboards

##Note. This is not a keyboard. This sample tries to demonstrate how to implement keyboard as addons.

###MainKeyboardApp - this app gets load all installed keyboard addons
###RussianKeyboard, EnglishKeyboard - standalone keyboard packages
###Code was taken from: https://github.com/AnySoftKeyboard/AnySoftKeyboard

###Sample usage
####Get all installed keyboards:
```
KeyboardManager keyboardManager = new KeyboardManager(context,
        "org.samples.langpack.KEYBOARD",
        "org.samples.langpack.keyboards");
List<KeyboardAddOnAndBuilder> builders = keyboardManager.findAllKeyboardBuilders();
Keyboard keyboard = builders.get(0).createKeyboard();
```

###Prepare language pack
Create empty receiver. Receiver's manifest must be like this.
```
<receiver android:exported="true" android:name="org.sample.langpack.PackBroadcastReceiver">
    <intent-filter>
        <action android:name="org.sample.langpack.KEYBOARD"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.ALTERNATIVE"/>
        <category android:name="android.intent.category.SELECTED_ALTERNATIVE"/>
    </intent-filter>
    <meta-data android:name="org.sample.langpack.keyboards" android:resource="@xml/keyboards"/>
    <meta-data android:name="org.sample.langpack.dictionaries" android:resource="@xml/dictionaries"/>
</receiver>
```

##Screenshot of running app with two keyboards installed