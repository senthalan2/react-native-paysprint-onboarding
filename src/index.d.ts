declare module 'react-native-paysprint-onboarding' {
    export interface OnBoardingResponseProps {
        status: boolean;
        response: number;
        message: string;
    }

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
    ): Promise<OnBoardingResponseProps>;
}
