package com.rntopsnackbar;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.androidadvance.topsnackbar.TSnackbar;

import java.util.Map;
import java.util.HashMap;

public class SnackBarModule extends ReactContextBaseJavaModule {

  private static final String DURATION_SHORT_KEY = "SHORT";
  private static final String DURATION_LONG_KEY = "LONG";

  public SnackBarModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "SnackBar";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put(DURATION_SHORT_KEY, TSnackbar.LENGTH_SHORT);
    constants.put(DURATION_LONG_KEY, TSnackbar.LENGTH_LONG);
    return constants;
  }

  @ReactMethod
  public void show(
    String message,
    int duration,
    String textColor,
    String backgroundColor,
    String buttonText,
    String buttonTextColor,
    String leftIcon,
    String rightIcon,
    int iconPadding,
    final Callback action) {

    try {
      View view = getCurrentActivity().getWindow().getDecorView().findViewById(android.R.id.content);
      TSnackbar snackbar = TSnackbar.make(view, message, duration);

      View snackbarView = snackbar.getView();
      snackbarView.setBackgroundColor(Color.parseColor(backgroundColor));
      TextView textView = snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
      textView.setTextColor(Color.parseColor(textColor));

      if (action != null) {
        snackbar.setAction(buttonText, new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              action.invoke();
          }
        });
        snackbar.setActionTextColor(Color.parseColor(buttonTextColor));
      }

      if (leftIcon != null) {
        int ImageId = getResourceId(getReactApplicationContext().getBaseContext(), leftIcon);
        snackbar.setIconLeft(ImageId, 34);
      }

      if (rightIcon != null) {
        int ImageId = getResourceId(getReactApplicationContext().getBaseContext(), rightIcon);
        snackbar.setIconRight(ImageId, 34);
      }

      snackbar.setIconPadding(iconPadding);
      snackbar.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private int getResourceId(Context context, String fileName) throws RuntimeException {
    try {
      return context.getResources().getIdentifier(fileName, "drawable", getCurrentActivity().getPackageName());
    } catch (Exception e) {
      throw new RuntimeException("Error getting Resource ID", e);
    }
  }
}
