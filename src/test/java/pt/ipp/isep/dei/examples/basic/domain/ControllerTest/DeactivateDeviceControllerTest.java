package pt.ipp.isep.dei.examples.basic.domain.ControllerTest;
import org.junit.jupiter.api.Test;


public class DeactivateDeviceControllerTest {

    @Test
    void deactivateDeviceSuccessfully() {
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device does not exist.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a non-existing device name.
     * The expected result is that the method returns false, indicating that the device could not be deactivated because the device does not exist.
     */
    @Test
    void deactivateDeviceNonExistingDevice() {
    }


    /**
     * This test checks if the deactivateDevice method correctly handles the case where the specified device is already inactive.
     * The test creates a US08DeactivateDeviceController object and calls the deactivateDevice method with a device that is already inactive.
     * The expected result is that the method returns false, indicating that the device could not be deactivated because it is already inactive.
     */
    @Test
    void deactivateDeviceWhenDeviceIsAlreadyInactive() {
    }

}
