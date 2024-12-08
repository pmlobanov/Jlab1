package ru.spbstu.telematics.java;
import org.junit.Test;
import junit.framework.TestCase;



public class AppTest 
    extends TestCase
{
    @Test
    public void testGetUUID() {
        generator_UUID generator = new generator_UUID();
        String uuid = generator.getUUID();
        assertTrue("UUID должен соответствовать формату xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx, где y = 8, 9, a или b", uuid.matches("^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$"));
    }
}