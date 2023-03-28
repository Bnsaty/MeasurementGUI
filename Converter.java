/**
 * UMGC CMIS 242
 * 
 * @author Brian Hinkle
 *         Date: (3/27/2023)
 *         This class is a parent class that will be used to create child
 *         classes
 *         executing measurement conversions. It contains 2 constructor options,
 *         use
 *         of which is determined by the obj. attribute of 'input'. Set/get
 *         methods are
 *         used to handle and retrieve obj. specifics.
 */

public class Converter {
    // Class attribute.
    private double input;

    // Constructor used for input that is not a number.
    public Converter() {
        this.input = Double.NaN;
    }

    // Constructor used for numeric input.
    public Converter(double input) {
        this.input = input;
    }

    // Get method to return input.
    public double getInput() {
        return input;
    }

    // Set method to set input.
    public void setInput(double input) {
        this.input = input;
    }

    // Parent method to be overridden in child class. Will be used to verify input.
    public double convert() {
        return input;
    }
}

// Child class to eval. input and return temp. measurement conversion.
class TemperatureConverter extends Converter {
    // 1st parent constructor (NaN constructor).
    public TemperatureConverter() {
        super();
    }

    // 2nd parent constructor (w/ numeric input).
    public TemperatureConverter(double input) {
        super(input);
    }

    // Change behavior of original (parent) method.
    @Override
    public double convert() {
        // Statement used to determine input characteristics.
        if (Double.isNaN(getInput())) {
            return Double.NaN;
        }
        // Get input. Convert and return result.
        return ((getInput() - 32) * 5) / 9;
    }
}

// Child class to eval. input and return dist. measurement conversion.
class DistanceConverter extends Converter {
    // 1st parent constructor (NaN constructor).
    public DistanceConverter() {
        super();
    }

    // 2nd parent constructor (w/ numeric input).
    public DistanceConverter(double input) {
        super(input);
    }

    // Change behavior of original (parent) method.
    @Override
    public double convert() {
        // Statement used to determine input characteristics.
        if (Double.isNaN(getInput())) {
            return Double.NaN;
        }
        // Get input. Convert and return result.
        return getInput() * 1.609;
    }
}