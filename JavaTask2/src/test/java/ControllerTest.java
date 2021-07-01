import com.chernoivan.Controller;
import com.chernoivan.GlobalConstants;
import com.chernoivan.Model;
import com.chernoivan.View;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ControllerTest {

    @Test
    public void testInputIntegerValueWithScanner() {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setRightNumber();

        Integer rightNumber = model.rightNumber;

        Integer result = controller.inputIntegerValueWithScanner(new Scanner(String.valueOf(rightNumber)));

        Assert.assertEquals(result, rightNumber);
    }

    @Test
    public void testFailInputIntegerValueWithScanner() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setRightNumber();

        Integer rightNumber = model.rightNumber;

        Integer result = controller.inputIntegerValueWithScanner(new Scanner(String.valueOf(rightNumber+1)));

        Assert.assertNotEquals(result, rightNumber);
    }

    @Test
    public void testWrongInput() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        try {
            controller.inputIntegerValueWithScanner(new Scanner(""));
        } catch (NoSuchElementException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void testLargeInputIntegerValueWithScanner() {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setRightNumber();


    }

}
