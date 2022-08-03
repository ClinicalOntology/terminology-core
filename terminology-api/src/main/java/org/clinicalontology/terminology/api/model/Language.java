package org.clinicalontology.terminology.api.model;

import java.util.Locale;

/**
 * ISO 2 Language Codes.
 */
public enum Language {
    AA("Afar"),
    AB("Abkhazian"),
    AF("Afrikaans"),
    AM("Amharic"),
    AR("Arabic"),
    AS("Assamese"),
    AY("Aymara"),
    AZ("Azerbaijani"),
    BA("Bashkir"),
    BE("Byelorussian"),
    BG("Bulgarian"),
    BH("Bihari"),
    BI("Bislama"),
    BN("Bengali, Bangla"),
    BO("Tibetan"),
    BR("Breton"),
    CA("Catalan"),
    CO("Corsican"),
    CS("Czech"),
    CY("Welsh"),
    DA("Danish"),
    DE("German"),
    DZ("Bhutani"),
    EL("Greek"),
    EN("English, American"),
    EO("Esperanto"),
    ES("Spanish"),
    ET("Estonian"),
    EU("Basque"),
    FA("Persian"),
    FI("Finnish"),
    FJ("Fiji"),
    FO("Faeroese"),
    FR("French"),
    FY("Frisian"),
    GA("Irish"),
    GD("Gaelic (Scots Gaelic)"),
    GL("Galician"),
    GN("Guarani"),
    GU("Gujarati"),
    HA("Hausa"),
    HI("Hindi"),
    HR("Croatian"),
    HU("Hungarian"),
    HY("Armenian"),
    IA("Interlingua"),
    IE("Interlingue"),
    IK("Inupiak"),
    IN("Indonesian"),
    IS("Icelandic"),
    IT("Italian"),
    IW("Hebrew"),
    JA("Japanese"),
    JI("Yiddish"),
    JW("Javanese"),
    KA("Georgian"),
    KK("Kazakh"),
    KL("Greenlandic"),
    KM("Cambodian"),
    KN("Kannada"),
    KO("Korean"),
    KS("Kashmiri"),
    KU("Kurdish"),
    KY("Kirghiz"),
    LA("Latin"),
    LN("Lingala"),
    LO("Laothian"),
    LT("Lithuanian"),
    LV("Latvian, Lettish"),
    MG("Malagasy"),
    MI("Maori"),
    MK("Macedonian"),
    ML("Malayalam"),
    MN("Mongolian"),
    MO("Moldavian"),
    MR("Marathi"),
    MS("Malay"),
    MT("Maltese"),
    MY("Burmese"),
    NA("Nauru"),
    NE("Nepali"),
    NL("Dutch"),
    NO("Norwegian"),
    OC("Occitan"),
    OM("Oromo, Afan"),
    OR("Oriya"),
    PA("Punjabi"),
    PL("Polish"),
    PS("Pashto, Pushto"),
    PT("Portuguese"),
    QU("Quechua"),
    RM("Rhaeto-Romance"),
    RN("Kirundi"),
    RO("Romanian"),
    RU("Russian"),
    RW("Kinyarwanda"),
    SA("Sanskrit"),
    SD("Sindhi"),
    SG("Sangro"),
    SH("Serbo-Croatian"),
    SI("Singhalese"),
    SK("Slovak"),
    SL("Slovenian"),
    SM("Samoan"),
    SN("Shona"),
    SO("Somali"),
    SQ("Albanian"),
    SR("Serbian"),
    SS("Siswati"),
    ST("Sesotho"),
    SU("Sudanese"),
    SV("Swedish"),
    SW("Swahili"),
    TA("Tamil"),
    TE("Tegulu"),
    TG("Tajik"),
    TH("Thai"),
    TI("Tigrinya"),
    TK("Turkmen"),
    TL("Tagalog"),
    TN("Setswana"),
    TO("Tonga"),
    TR("Turkish"),
    TS("Tsonga"),
    TT("Tatar"),
    TW("Twi"),
    UK("Ukrainian"),
    UR("Urdu"),
    UZ("Uzbek"),
    VI("Vietnamese"),
    VO("Volapuk"),
    WO("Wolof"),
    XH("Xhosa"),
    YO("Yoruba"),
    ZH("Chinese"),
    ZU("Zulu");

    private final String text;

    Language(String text) {
        this.text = text;
    }

    /**
     * @return The language code.
     */
    public String getCode() {
        return name().toLowerCase();
    }

    /**
     * @return The human-readable language name.
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     * @return The language for the default locale.
     */
    public static Language getDefault() {
        return fromLocale(Locale.getDefault());
    }

    /**
     * Returns the language for the specified locale.
     *
     * @param locale The locale.
     * @return The language for the locale (possibly null).
     */
    public static Language fromLocale(Locale locale) {
        try {
            return Language.valueOf(locale.getLanguage().toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }
}
