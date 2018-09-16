// @flow

import { NativeModules } from 'react-native';

type SnackBar = {
  SHORT: number,
  LONG: number,
  show: () => void,
};

type Option = {
  message: string,
  duration: number,
  textColor?: string,
  backgroundColor?: string,
  buttonText?: string,
  buttonTextColor?: string,
  leftIcon?: string,
  rightIcon?: string,
  iconPadding?: number,
  callback?: () => void,
}

const TopSnackBar: SnackBar = {
  SHORT: NativeModules.SnackBar.SHORT,
  LONG: NativeModules.SnackBar.LONG,

  show(option: Option) {
    const message = option.message || 'Empty String';
    const duration = option.duration || NativeModules.SnackBar.SHORT;
    const textColor = option.textColor || '#ffffff';
    const backgroundColor = option.backgroundColor || '#2aa2ef';
    const buttonText = option.buttonText || 'Done';
    const buttonTextColor = option.buttonTextColor || '#ffffff';
    const leftIcon = option.leftIcon || null;
    const rightIcon = option.rightIcon || null;
    const iconPadding = option.iconPadding || 8;
    const callback = option.callback || null;

    NativeModules.SnackBar.show(
      message,
      duration,
      textColor,
      backgroundColor,
      buttonText,
      buttonTextColor,
      leftIcon,
      rightIcon,
      iconPadding,
      callback,
    );
  },
};

export default TopSnackBar;
