package ac.cam.jj625.sets;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)

public class FunctionalArrayTest {
    @Test
    public void functionalArray_get_throwsArrayOutOfBounds() {
        // ARRANGE
        FunctionalArray fr = new FunctionalArray(10);

        // ACT

        // ASSERT
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> fr.get(11));
    }
    @Test
    public void functionalArray_set() {
        // ARRANGE
        FunctionalArray fr = new FunctionalArray(3);

        // ACT

        // ASSERT
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> fr.set(9,5));
    }

    @Test
    public void functionalArray_set_get_worksOnce() {
        // ARRANGE
        FunctionalArray fr = new FunctionalArray(10);

        // ACT
        fr.set(2, 5);
        int a = fr.get(2);

        // ASSERT
        assertThat(a).isEqualTo(5);
    }

    @Test
    public void functionalArray_set_get_worksOverwriting() {
        // ARRANGE
        FunctionalArray fr = new FunctionalArray(10);

        // ACT
        fr.set(3, 5);
        fr.set(3, 7);
        int a = fr.get(3);

        // ASSERT
        assertThat(a).isEqualTo(7);
    }

    @Test
    public void functionalArray_set_get_worksMultiple() {
        // ARRANGE
        FunctionalArray fr = new FunctionalArray(10);

        // ACT
        fr.set(2, 5);
        fr.set(3, 7);
        int a = fr.get(2);
        int b = fr.get(3);

        // ASSERT
        assertThat(a).isEqualTo(5);
        assertThat(b).isEqualTo(7);
    }

    @Test
    public void functionalArray_constructor_initialisesZeroes() {
        // ARRANGE

        // ACT
        FunctionalArray fr = new FunctionalArray(4);
        int a = fr.get(2);

        // ASSERT
        assertThat(a).isEqualTo(0);
    }

    //
}
