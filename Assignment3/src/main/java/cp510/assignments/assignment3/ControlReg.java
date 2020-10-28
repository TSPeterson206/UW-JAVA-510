package cp510.assignments.assignment3;

public class ControlReg {

    /**
     * The ControlReg class for UW java 510.
     * 
     * The ControlReg class has methods to both encode and decode a 16-bit
     * register. It also contains setters and getters to establish and retrieve
     * the six values of the supplied register.
     * 
     * @author Toby Peterson.
     */

    private int origin;
    private int security;
    private int data;
    private int count;
    private int start;
    private int control;

    private static int originMask = 0b000000000000111;
    private static int securityMask = 0b000000000011000;
    private static int dataMask = 0b0000000111100000;
    private static int countMask = 0b000011000000000;
    private static int startMask = 0b0000100000000000;
    private static int controlMask = 0b1111000000000000;

    /**
     * ControlReg constructor.
     * 
     * @param reg A binary 16-bit register.
     */

    public ControlReg(int reg) {
        decodeReg(reg);
        encodeReg();
    }

    /**
     * The getOrigin getter.
     * 
     * @return An integer representing the origin value of the inputed register
     *         (in decimal).
     */
    public int getOrigin() {
        return this.origin;
    };

    /**
     * The setOrigin setter.
     * 
     * @param origin The decimal value of the origin portion of the register to
     *               be set.
     */

    public void setOrigin(int origin) {
        this.origin = origin;
    };

    /**
     * The getSecurity getter.
     * 
     * @return An integer representing the security value of the inputed
     *         register (in decimal).
     */

    public int getSecurity() {
        return this.security;
    };

    /**
     * The setSecurity setter.
     * 
     * @param security The decimal value of the security to be set.
     */
    public void setSecurity(int security) {
        this.security = security;
    };

    /**
     * The getData getter.
     * 
     * @return An integer representing the data value of the inputed register
     *         (in decimal).
     */
    public int getData() {
        return this.data;
    };

    /**
     * The setData setter.
     * 
     * @param data The decimal value of the data portion of the register to be
     *             set.
     */
    public void setData(int data) {
        this.data = data;
    };

    /**
     * The getCount getter.
     * 
     * @return An integer representing the count value of the inputed register
     *         (in decimal).
     */

    public int getCount() {
        return this.count;
    };

    /**
     * The setCount setter.
     * 
     * @param count The decimal value of the count portion of the register to be
     *              set.
     */

    public void setCount(int count) {
        this.count = count;
    };

    /**
     * The getStart getter.
     * 
     * @return An integer representing the start value of the inputed register
     *         (in decimal).
     */

    public int getStart() {
        return this.start;
    };

    /**
     * The setStart setter.
     * 
     * @param start The decimal value of the start portion of the register to be
     *              set.
     */
    public void setStart(int start) {
        this.start = start;
    };

    /**
     * The getControl getter.
     * 
     * @return An integer representing the control value of the inputed register
     *         (in decimal).
     */

    public int getControl() {
        return this.control;
    };

    /**
     * The setControl setter.
     * 
     * @param control The decimal value of the control portion of the register
     *                to be set.
     */

    public void setControl(int control) {
        this.control = control;
    };

    /**
     * The decodeReg function that decodes a given register and uses the decoded
     * values to set this object's properties.
     * 
     * @param reg An encoded 16-bit register.
     */
    public void decodeReg(int reg) {
        origin = (reg & originMask) >> 0;
        security = (reg & securityMask) >> 3;
        data = (reg & dataMask) >> 5;
        count = (reg & countMask) >> 9;
        start = (reg & startMask) >> 11;
        control = (reg & controlMask) >> 12;
    };

    /**
     * The encodeReg method that encodes the encapsulated properties into an
     * integer value.
     * 
     * @return An integer that is the encoded value of the inputed register.
     */

    public int encodeReg() {

        int reg = 0;
        reg = reg | origin << 0;
        reg = reg | security << 3;
        reg = reg | data << 5;
        reg = reg | count << 9;
        reg = reg | start << 11;
        reg = reg | control << 12;
//        System.out.println("encodedreg: " + Integer.toBinaryString(reg));
//        System.out.println("encodedregint: " + reg);
        return reg;
    };

    /**
     * The toString method that outputs a string representing the individual
     * properties that comprise the register.
     * 
     * @return A human readable string displaying the 6 fields of the inputed
     *         register.
     */
    public String toString() {
        return "origin=" + origin + ",security=" + security + ",data=" + data
        + ",count=" + count + ",start=" + start + ",control=" + control;
    }

}
