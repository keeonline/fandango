package com.keeonline.fandango.iso8583.field.domain.complex;

public class CardAcceptorNameLocation {

    String cardAcceptorOrAtmLocation;
    String cityName;
    String countryCode;

    public String getCardAcceptorOrAtmLocation() {
        return cardAcceptorOrAtmLocation;
    }
    public void setCardAcceptorOrAtmLocation(String cardAcceptorOrAtmLocation) {
        this.cardAcceptorOrAtmLocation = cardAcceptorOrAtmLocation;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "cardAcceptorOrAtmLocation=" + cardAcceptorOrAtmLocation + ", cityName="
                + cityName + ", countryCode=" + countryCode;
    }

}
