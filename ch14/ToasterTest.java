/*
 * Simulate a toaster with slots, voltage, slices of bread,
 * and darkness control
 */
class PowerSupply {
    private int voltage;
    private boolean turnedOn;
    
    public PowerSupply(int voltage) {
        this.setVoltage(voltage);
        // new power supplies are always shipped in the "off" position
        this.turnedOn = false;
    }
    
    public int getVoltage() {
        return voltage;
    }
    
    public void setVoltage(int voltage) {
        if (voltage == 110 || voltage == 220) {
            this.voltage = voltage;
        } else {
            this.voltage = 110;
        }
    }
    public boolean getTurnedOn() {
        return turnedOn;
    }
    
    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }
}

class Dial {
    private double currentValue;
    private int minValue;
    private int maxValue;
    
    public Dial(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        // new dials are always shipped set to lowest value
        this.currentValue = minValue;
    }
    
    public double getCurrentValue() {
        return currentValue;
    }
    
    // make sure that the new value is clamped in the
    // range minValue - maxValue (inclusive)
    public void setCurrentValue(double currentValue) {
        this.currentValue = Math.min(maxValue, Math.max(minValue, currentValue));
    }
    
    public int getMinValue() {
        return minValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
}
    
class Toaster {
    private int nSlots;
    private int nSlices;
    private PowerSupply power;
    private Dial darkness;
    
    public Toaster(int nSlots, int voltage) {
        this.power = new PowerSupply(voltage);
        this.darkness = new Dial(1, 10);
        this.setNSlots(nSlots);
        this.nSlices = 0;
    }
    
    public PowerSupply getPower() {
        return power;
    }
    
    public Dial getDarkness() {
        return darkness;
    }
    
    public int getNSlots() {
        return nSlots;
    }
    
    public void setNSlots(int nSlots) {
        this.nSlots = Math.max(1, Math.min(4, nSlots));
    }
    
    public int getNSlices() {
        return nSlices;
    }
    
    public void setNSlices(int nSlices) {
        this.nSlices = Math.min(nSlots, Math.abs(nSlices));
    }
    
    public void insertBread(int n) {
        if (power.getTurnedOn()) {
            setNSlices(nSlices + n);
        }
    }
    
    public void popBread() {
        if (power.getTurnedOn()) {
            setNSlices(0);
        }
    }
    
    public String toString() {
        return String.format("%d slot %dV toaster with %d slice%s at darkness %.1f: %s",
            nSlots, power.getVoltage(),
            nSlices, ((nSlices == 1) ? "" : "s"),
            darkness.getCurrentValue(),
            ((power.getTurnedOn())? "ON" : "OFF"));
    }
}

public class ToasterTest {
    public static void main(String[] args) {
        Toaster northAmTwo = new Toaster(2, 110);
        Toaster euroFour = new Toaster(4, 220);
        
        northAmTwo.getPower().setTurnedOn(true);
        northAmTwo.getDarkness().setCurrentValue(4);
        northAmTwo.insertBread(1);
        
        System.out.println(northAmTwo);
        System.out.println(euroFour);
    }
}

