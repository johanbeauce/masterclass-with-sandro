package be.beauce.training.masterclasswithsandro.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsConverterShould {

    RomanNumeralsConverter romanNumeralsConverter;

    @BeforeEach
    void setUp() {
        romanNumeralsConverter = new RomanNumeralsConverter();
    }

    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "9, IX",
            "10, X",
            "18, XVIII",
            "19, XIX",
            "20, XX",
            "40, XL",
            "45, XLV",
            "50, L",
            "90, XC",
            "100, C",
            "150, CL",
            "400, CD",
            "500, D",
            "900, CM",
            "1000, M",
            "2499, MMCDXCIX",
            "3949, MMMCMXLIX"
    })
    void return_i_given_one(int number, String romanNumeral) {
        assertThat(romanNumeralsConverter.convert(number)).isEqualTo(romanNumeral);
    }
}
