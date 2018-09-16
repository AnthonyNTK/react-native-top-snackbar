import { NativeModules } from 'react-native';

describe('TopSnackbar module', () => {
  let TopSnackbar;

  beforeAll(() => {
    NativeModules.SnackBar = {
      show: jest.fn(),
    };

    TopSnackbar = require('../index').default;
  });

  beforeEach(() => {
    NativeModules.SnackBar.show.mockClear();
  });

  it('calls native with default params', () => {
    TopSnackbar.show({});

    expect(NativeModules.SnackBar.show.mock.calls).toMatchSnapshot();
  });

  it('calls native with specified params', () => {
    TopSnackbar.show({
      message: 'Hello, World!',
      duration: NativeModules.SnackBar.SHORT,
      textColor: '#ffffff',
      backgroundColor: '#f4511e',
      leftIcon: 'example',
      iconPadding: 5,
      callback: () => alert('hihihi')
    });

    expect(NativeModules.SnackBar.show.mock.calls).toMatchSnapshot();
  });
});
