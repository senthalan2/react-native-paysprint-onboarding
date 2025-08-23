import PaysprintOnboarding from './NativePaysprintOnboarding';
import type { OnBoardingResponseProps } from './types';

export function startPaysprintOnBoarding(
  partnerId: string,
  partnerApiKey: string,
  merchantCode: string,
  merchantMobile: string,
  firmName: string,
  email: string,
  lat: string,
  lng: string,
  pipe: string
): Promise<OnBoardingResponseProps> {
  return PaysprintOnboarding.startPaysprintOnBoarding(
    partnerId,
    partnerApiKey,
    merchantCode,
    merchantMobile,
    firmName,
    email,
    lat,
    lng,
    pipe
  );
}
