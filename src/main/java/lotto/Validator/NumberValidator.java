package lotto.Validator;

import java.util.List;
import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class NumberValidator {
    private static final String POSITIVE_INTEGER = "\\d+";
    private static final String NEGATIVE_INTEGER = "-\\d+";

    public static void isNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NEGATIVE.getMessage());
        }
    }

    public static void isNegative(String num) {
        if (num.matches(NEGATIVE_INTEGER)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NEGATIVE.getMessage());
        }
    }

    public static void isBlank(String num) {
        if (num.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_BLANK.getMessage());
        }
    }

    public static void isWrongType(String num) {
        if (!num.matches(POSITIVE_INTEGER)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_TYPE.getMessage());
        }
    }

    public static void isOutRange(int num) {
        if (num > ConfigurationNumbers.MAX_NUMBER.getNumber() || num < ConfigurationNumbers.MIN_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public static void isDuplicatedBonus(int num, List<Integer> numbers) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS.getMessage());
        }
    }
}
