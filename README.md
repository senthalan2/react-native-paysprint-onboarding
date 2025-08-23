# react-native-paysprint-onboarding

This is a React Native module that provides a seamless integration of the Paysprint Onboarding SDK into your React Native Android applications.

For reference, you may check out the ([Pay Sprint Onboarding Mobile SDK](https://pay-sprint.readme.io/reference/onboarding-mobile-sdk)).

## Installation

```sh

npm  install  react-native-paysprint-onboarding

```

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
