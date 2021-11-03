import java.util.HashMap;
import java.util.Map;

public enum MathematicalOperation {
    ADD("add") {
        @Override
        public Double calculate(double a, double b) {
            return a + b;
        }
    },
    MULTIPLY("multiply") {
        @Override
        public Double calculate(double a, double b) {
            return a * b;
        }
    },
    SUBTRACT("subtract") {
        @Override
        public Double calculate(double a, double b) {
            return a - b;
        }
    };

    private final String name;

    private static final Map<String, MathematicalOperation> OPERATIONS;

    static {
        OPERATIONS = new HashMap<>();
        for (MathematicalOperation value : values()) {
            OPERATIONS.put(value.name, value);
        }
    }

    MathematicalOperation(String name) {
        this.name = name;
    }

    public abstract Double calculate(double a, double b);

    public static MathematicalOperation findOperationByName(String name) {
        MathematicalOperation mathematicalOperation = OPERATIONS.get(name);

        if (mathematicalOperation != null) {
            return mathematicalOperation;
        }
        throw new UnsupportedOperationException(name);
    }
}
