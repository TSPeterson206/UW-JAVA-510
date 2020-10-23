package cp510.assignments.assignment3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControlRegTest {

    @BeforeEach
    void init() {
    }

    ControlReg reg = new ControlReg(0xA565);

    @Test
    void getData() {

        Assertions.assertEquals(11, reg.getData());
    }

    @Test
    void getOrigin() {

        Assertions.assertEquals(5, reg.getOrigin());
    }

    @Test
    void getControl() {

        Assertions.assertEquals(10, reg.getControl());
    }

    @Test
    void getStart() {

        Assertions.assertEquals(0, reg.getStart());
    }

    @Test
    void getCount() {

        Assertions.assertEquals(2, reg.getCount());
    }

    @Test
    void getSecurity() {

        Assertions.assertEquals(0, reg.getSecurity());
    }

    @Test
    void encode() {
        Assertions.assertEquals(42341, reg.encodeReg());

    }
}
