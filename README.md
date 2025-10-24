# react-native-paysprint-onboarding

This is a React Native module that provides a seamless integration of the Paysprint Onboarding SDK into your React Native Android applications.

For reference, you may check out the ([Pay Sprint Onboarding Mobile SDK](https://pay-sprint.readme.io/reference/onboarding-mobile-sdk)).

## Installation

```sh

npm  install  react-native-paysprint-onboarding

```

### Android Setup

#### 1. Add `.aar` dependency

Download the required `.aar` from the [Pay Sprint Onboarding Mobile SDK Docs](https://pay-sprint.readme.io/reference/onboarding-mobile-sdk) and place it in your app module:

`android/app/libs/onboardinglib_live-release.aar`

⚠️ Make sure the filename matches exactly, including extension and case.

#### 2. Configure Gradle to include local `.aar` files

Open your app module's `android/app/build.gradle` and ensure there is a `repositories` block.

- If it exists, add the `flatDir` line inside it:

```js
repositories {
    google()
    mavenCentral()
    flatDir {
        dirs 'libs'  // <- This tells Gradle to look in android/app/libs for .aar files
    }
}
```

- If the `repositories` block does not exist, add the whole block above.

#### 3. Update gradle.properties

Add the following line to your `android/gradle.properties` file in your project:

```properties
android.enableJetifier=true
```

✅ This tells Gradle to enable Jetifier, which is required for compatibility with the Paysprint SDK, as it still depends on the old Android Support libraries.

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
