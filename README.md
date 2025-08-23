# react-native-paysprint-onboarding

This is a React Native module that provides a seamless integration of the Paysprint Onboarding SDK into your React Native Android applications.

For reference, you may check out the ([Pay Sprint Onboarding Mobile SDK](https://pay-sprint.readme.io/reference/onboarding-mobile-sdk)).

## Installation

```sh

npm  install  react-native-paysprint-onboarding

```

### Android Setup (Optional)

#### 1. Add `.aar` dependency

By default, the package includes the **Pay Sprint UAT Mobile SDK** `.aar` file inside `react-native-paysprint-onboarding/android/libs`.

If you want to use a different `.aar` file as mentioned in the ([Pay Sprint Onboarding Mobile SDK Docs](https://pay-sprint.readme.io/reference/onboarding-mobile-sdk)), follow the steps below:

1. Place your `.aar` file in your app project at:
   `android/app/libs/<sdk_file_name>.aar`
2. Add a property in your root `android/build.gradle` below the `buildscript`:

```js
	buildscript {
		...
	}

	ext {
	    PaySprintOnboardingLibPath= "app/libs/<sdk_file_name>.aar"
	}
```

The package will automatically resolve the path and use your `.aar` instead of the bundled one.

## Usage

```js
import { startPaysprintOnBoarding } from 'react-native-paysprint-onboarding';

// ...

startPaysprintOnBoarding(
  partnerId, // string
  partnerApiKey, // string
  merchantCode, // string
  merchantMobile, // string
  firmName, // string
  email, // string
  lat, // string
  lng, // string
  pipe // string
)
  .then((res) => {
    console.log(res, 'Response');
  })
  .catch((e) => {
    console.log(e, 'Error');
  });
```

## Response JSON Object

`startPaysprintOnBoarding()` Method Reponse

| Key      | Type    | Description                                            |
| -------- | ------- | ------------------------------------------------------ |
| status   | boolean | Indicates whether the onboarding was successful or not |
| response | number  | Numeric code representing the response status          |
| message  | string  | Message describing the result                          |

## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)

- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)

- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---
