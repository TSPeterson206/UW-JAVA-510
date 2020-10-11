package cp510.assignments;

import org.junit.jupiter.api.Test;

import uw.syp.java.tools.Turtle;

class Assignment1Test
{
    @Test
    void test()
    {
        Turtle  toots   = new Turtle();
        toots.fillCircle( 64 );
        Turtle.sleep( 2000 );
    }
}
