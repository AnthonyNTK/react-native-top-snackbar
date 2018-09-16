# React Native Top SnackBar

A React Native Wrapper of [TSnackBar](https://github.com/AndreiD/TSnackBar)

## Introduction

react-native-top-snackbar is a JS wrapper of the native component TSnackBar (All Credits belongs to AndreiD and THANKS AGAIN FOR THIS GREAT LIB)

## Installation

1. Install the package
```shell
npm install react-native-top-snackbar --save
```

2. Automatic link
```shell
react-native link react-native-top-snackbar
```

3. Manual Link (not essential)

    In case `react-native link` missed something, checking the following

    Open android/app/build.gradle, add this line
    ```
    dependencies {
    ...
      +    compile project(':react-native-top-snackbar')     
    }
    ```

    Open android/settings.gradle, and add these lines which will add Android project dependency to your app
    ```
    include ':app'      
    + include ':react-native-top-snackbar'
    + project(':react-native-top-snackbar').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-top-snackbar/android')
    ```

    Add these lines to MainApplication.java, so that the package becomes part of react native package.
    ```
    ...
    + import com.rntopsnackbar.SnackBarPackage;
    ...
    protected List<ReactPackage> getPackages() {
          return Arrays.<ReactPackage>asList(
              new MainReactPackage(),
    +          new SnackBarPackage()
          );
        }
      };
    ...
    ```

## Example

```jsx
import TopSnackBar from 'react-native-top-snackbar';

TopSnackBar.show({
  message: 'Hello, World!',
  duration: TopSnackBar.SHORT,
  textColor: '#ffffff',
  backgroundColor: '#f4511e',
  buttonText = 'Done',
  buttonTextColor = '#ffffff',
  leftIcon: 'example',
  rightIcon: 'example',
  iconPadding: 5,
  callback: () => alert('See me?')
});
...
```

## Props

|Property        |Type                      |Optional|Description                                                  |
|:---------------|:------------------------:|:------:|------------------------------------------------------------:|
|message         |string                    |No      |The display message                                          |
|duration        |enum ['SHORT', 'LONG']    |No      |The duration of the message                                  |
|textColor       |string                    |Yes     |Color of the display message                                 |
|backgroundColor |string                    |Yes     |BackgroundColor of the snackbar                              |
|buttonText      |string                    |Yes     |The title of the action button                               |
|buttonTextColor |string                    |Yes     |Color of the text of action button                           |
|leftIcon        |string                    |Yes     |File name of the icon to be displayed on the left of snackbar|
|right           |string                    |Yes     |File name of the icon to be displayed on the left of snackbar|
|iconPadding     |number                    |Yes     |Padding of the icon(s)                                       |
|callback        |function                  |Yes     |Callback to be triggered after action button being pressed   |

***To use icon, you need to store the icon in android/app/src/main/res/drawable.
For Example, to use this icon inside `drawable` folder: 'icon/example.png', just pass the full path inside `drawable` without file extension to `props`, i.e. {leftIcon: 'icon/example'}***

## Other

This package makes use of [TSnackBar](https://github.com/AndreiD/TSnackBar) for native side rendering, check it out and drop a star if possible

## Contribution

Any suggestion and PR is welcome
# New Document
