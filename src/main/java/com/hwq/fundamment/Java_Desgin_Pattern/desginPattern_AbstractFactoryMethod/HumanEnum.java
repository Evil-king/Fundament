package com.hwq.fundamment.Java_Desgin_Pattern.desginPattern_AbstractFactoryMethod;

public enum HumanEnum {

    YellowFemaleHuman("desginPattern_AbstractFactoryMethod.YellowFemaleHuman"),
    YellowMaleHuman("desginPattern_AbstractFactoryMethod.YellowMaleHuman"),
    WhiteFemailHuman("desginPattern_AbstractFactoryMethod.WhiteFemailHuman"),
    WhiteMaleHman("desginPattern_AbstractFactoryMethod.WhiteMaleHman"),
    BlackFemaleHuman("desginPattern_AbstractFactoryMethod.YellowFemaleHuman"),
    BlackMaleHuman("desginPattern_AbstractFactoryMethod.YellowMaleHuman"),
    ;

    private String value = "";

    private HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
