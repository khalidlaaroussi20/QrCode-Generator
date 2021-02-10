package EncoderConstants;

import DataAnalyse.Mode_Encoding;

public class CharCountIndicator {
    public static int getLength(int version, int encMode) {
        if (1 <= version && version <= 9) {
            switch (encMode) {
            case Mode_Encoding.Numeric_Mode:
                return 10;
            case Mode_Encoding.Alphanumeric_Mode:
                return 9;
            case Mode_Encoding.Byte_Mode:
                return 8;
            default:
                throw new IllegalArgumentException("encMode");
            }
        }

        if (10 <= version && version <= 26) {
            switch (encMode) {
            case Mode_Encoding.Numeric_Mode:
                return 12;
            case Mode_Encoding.Alphanumeric_Mode:
                return 11;
            case  Mode_Encoding.Byte_Mode:
                return 16;
            default:
                throw new IllegalArgumentException("encMode");
            }
        }

        if (27 <= version && version <= 40) {
            switch (encMode) {
            case  Mode_Encoding.Numeric_Mode:
                return 14;
            case Mode_Encoding.Alphanumeric_Mode:
                return 13;
            case Mode_Encoding.Byte_Mode:
                return 16;
            default:
                throw new IllegalArgumentException("encMode");
            }
        }

        throw new IllegalArgumentException("version");
    }
}
