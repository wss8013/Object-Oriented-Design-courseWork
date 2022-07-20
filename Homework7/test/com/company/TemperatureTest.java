package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Temperature, both Celsius and Fahrenheit representations.
 */
public class TemperatureTest {

  private Temperature cTemp;
  private Temperature fTemp;
  private Temperature fTemp50;
  private Temperature cTemp100;
  private Temperature cTemp10;
  private Temperature fTemp32;
  private Temperature cTemp0;

  @Before
  public void init() {
    cTemp = new CelsiusTemperature(100);
    fTemp = new FahrenheitTemperature(100, true);
    fTemp50 = new FahrenheitTemperature(50);
    cTemp10 = new CelsiusTemperature(10);
    cTemp100 = new CelsiusTemperature(100);
    fTemp32 = new FahrenheitTemperature(32);
    cTemp0 = new CelsiusTemperature(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForInvalidFTemp() {
    new FahrenheitTemperature(-1000);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForInvalidCTemp() {
    new CelsiusTemperature(-1000);
  }

  @Test
  public void testObservers() {
    assertEquals(100, cTemp.inCelsius(), 0.001);
    assertEquals(212, cTemp.inFahrenheit(), 0.001);
    assertEquals(373.15, cTemp.inKelvin(), 0.001);
  }

  @Test
  public void testInF() {
    assertEquals(212, fTemp.inFahrenheit(), 0.001);
  }

  @Test
  public void testEquals() {
    assertFalse(fTemp.equals(null));
    assertEquals(fTemp50, cTemp10);
    assertEquals(cTemp100, cTemp);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddFTempNullCase() {
    fTemp.add(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddCTempNullCase() {
    cTemp.add(null);
  }

  @Test
  public void testAddCTemp() {
    assertEquals(cTemp.add(fTemp), new CelsiusTemperature(200));
    assertEquals(fTemp.add(cTemp), new FahrenheitTemperature(424));
    assertEquals(fTemp.add(cTemp), new FahrenheitTemperature(424));
    assertEquals(fTemp32.add(cTemp0), new FahrenheitTemperature(64));
    assertEquals(cTemp0.add(fTemp32), new CelsiusTemperature(0));
  }

  @Test
  public void testToString() {
    assertEquals(cTemp.toString(), "100.0° Celsius");
    assertEquals(fTemp.toString(), "212.0° Fahrenheit");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCompareTo() {
    assertTrue(fTemp32.compareTo(cTemp0) == 0);
    assertTrue(cTemp100.compareTo(cTemp0) > 0);
    assertTrue(cTemp0.compareTo(cTemp100) < 0);
    assertTrue(fTemp32.compareTo(cTemp100) < 0);
    assertTrue(fTemp32.compareTo(fTemp50) < 0);
    assertTrue(fTemp50.compareTo(fTemp32) > 0);
    fTemp50.compareTo(null);

  }
}
