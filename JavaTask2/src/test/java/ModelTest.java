import com.chernoivan.GlobalConstants;
import com.chernoivan.Model;
import org.junit.Assert;
import org.junit.Test;


public class ModelTest {
    @Test
    public void testRightNumberSearcher() {
        Model model = new Model();

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setRightNumber();

        int right = model.rightNumber;
        if (model.numberSearcher(right))
            Assert.fail();
    }

    @Test
    public void testWrongNumberSearcher() {
        Model model = new Model();

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setRightNumber();

        int right = model.rightNumber+1;
        if (!model.numberSearcher(right))
            Assert.fail();
    }
}
