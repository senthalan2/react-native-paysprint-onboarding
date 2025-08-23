import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';
import type { OnBoardingResponseProps } from './types';

export interface Spec extends TurboModule {
  startPaysprintOnBoarding(partnerId: string,
    partnerApiKey: string,
    merchantCode: string,
    merchantMobile: string,
    firmName: string,
    email: string,
    lat: string,
    lng: string,
    pipe: string): Promise<OnBoardingResponseProps>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('PaysprintOnboarding');
