import com.chernoivan.Arithmetics;
import org.junit.Assert;
import org.junit.Test;

public class TestArithmetics {
    @Test
    public void testAdd() {
        Arithmetics arithmetics = new Arithmetics();
        double res = arithmetics.add(3, 7);
        if(res != 10) Assert.fail();
    }

    @Test
    public void testMult() {
        Arithmetics arithmetics = new Arithmetics();
        double res = arithmetics.mult(3, 7);
        if(res != 21) Assert.fail();
    }

    @Test
    public void testDeduct() {
        Arithmetics arithmetics = new Arithmetics();
        double res = arithmetics.deduct(3, 7);
        if(res != -4) Assert.fail();
    }

    @Test
    public void testDiv() {
        Arithmetics arithmetics = new Arithmetics();
        double res = arithmetics.div(10, 5);
        if(res != 2) Assert.fail();
    }
}
