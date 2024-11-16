package ac.cam.jj625.sets;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)


public class SearchSetTest {
    // test insert
    @Test
    public void searchSet_insert_worksLeft() {
        // ARRANGE
        SearchSet s = new SearchSet();
        // ACT
        s.insert(5);
        s.insert(2);
        s.insert(1);

        // ASSERT
        assertThat(s.contains(2)).isEqualTo(true);
        assertThat(s.contains(3)).isEqualTo(false);
        assertThat(s.getNumberElements()).isEqualTo(3);
    }
    @Test
    public void searchSet_insert_worksRight() {
        // ARRANGE
        SearchSet s = new SearchSet();
        // ACT
        s.insert(5);
        s.insert(6);
        s.insert(7);

        // ASSERT
        assertThat(s.contains(6)).isEqualTo(true);
        assertThat(s.contains(1)).isEqualTo(false);
        assertThat(s.getNumberElements()).isEqualTo(3);
    }
    // test getNumberElements
    @Test
    public void searchSet_getNumberElements_worksEmpty() {
        // ARRANGE
        SearchSet s = new SearchSet();
        // ACT

        // ASSERT
        assertThat(s.getNumberElements()).isEqualTo(0);
    }
    @Test
    public void searchSet_getNumberElements_worksNonEmpty() {
        // ARRANGE
        SearchSet s = new SearchSet();
        // ACT
        s.insert(5);
        s.insert(6);
        s.insert(7);
        s.insert(8);

        // ASSERT
        assertThat(s.getNumberElements()).isEqualTo(4);
    }

    @Test
    public void searchSet_getNumberElements_worksWithDuplicates() {
        // ARRANGE
        SearchSet s = new SearchSet();
        // ACT
        s.insert(5);
        s.insert(5);
        s.insert(6);
        s.insert(7);
        s.insert(8);

        // ASSERT
        assertThat(s.getNumberElements()).isEqualTo(4);
    }
    // test contains
}
