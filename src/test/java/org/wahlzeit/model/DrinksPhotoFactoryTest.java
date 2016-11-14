package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DrinksPhotoFactoryTest {
    @Test(expected = IllegalStateException.class)
    public void testSettingInstanceTwice() {
        DrinksPhotoFactory factory = DrinksPhotoFactory.getInstance();
        DrinksPhotoFactory.setInstance(new DrinksPhotoFactory());
    }

    @Test
    public void testFactorySingletonFeature() {
        DrinksPhotoFactory f1 = DrinksPhotoFactory.getInstance();
        DrinksPhotoFactory f2 = DrinksPhotoFactory.getInstance();
        assertEquals(f1, f2);
    }
}
