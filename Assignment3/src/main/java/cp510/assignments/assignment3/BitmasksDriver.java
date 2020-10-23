package cp510.assignments.assignment3;

public class BitmasksDriver {
    public static void main(String[] args) {
        int reg1 = 0b0110_1_01_1000_11_001;
        int reg2 = 0b1000_0_10_0001_00_100;
        int reg3 = 0b1001_1_11_1110_11_011;

        ControlReg control1 = new ControlReg(reg1);
        ControlReg control2 = new ControlReg(reg2);
        ControlReg control3 = new ControlReg(reg3);

        System.out.println(control1);
        System.out.println(control2);
        System.out.println(control3);
        exerciseAccessors();
    }

    private static void exerciseAccessors() {
        ControlReg control4 = new ControlReg(0);
        control4.setOrigin(3);
        control4.setSecurity(2);
        control4.setData(9);
        control4.setCount(2);
        control4.setStart(1);
        control4.setControl(11);

        StringBuilder bldr = new StringBuilder();
        bldr.append(control4.getOrigin()).append(", ")
        .append(control4.getSecurity()).append(", ").append(control4.getData())
        .append(", ").append(control4.getCount()).append(", ")
        .append(control4.getStart()).append(", ").append(control4.getControl());

        System.out.println(bldr);
    }
}