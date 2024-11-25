package uk.ac.cam.jj625.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class ArrayedListTest {

    @Test
    public void arrayedList_toStringIsEmptyList_whenListEmpty() {
        // ARRANGE
        var empty = new ArrayedList<Integer>();

        // ACT
        String value = empty.toString();

        // ASSERT
        assertThat(value).isEqualTo("[]");
    }

    @Test
    public void arrayedList_toStringIsSingleItem_whenListContainsOneItem() {
        // ARRANGE
        ArrayedList<Integer> list = new ArrayedList<Integer>();
        list.addFirst(1);

        // ACT
        String value = list.toString();

        // ASSERT
        assertThat(value).isEqualTo("[1]");
    }
    @Test
    public void arrayedList_reverse_worksWithNonEmptyList() {
        // ARRANGE
        Integer[] arr = {1,2,3};

        // ACT
        ArrayedList<Integer> list = ArrayedList.create(arr);
        list.reverse();

        // ASSERT
        assertThat(list.toString()).isEqualTo("[3,2,1]");
    }
    @Test
    public void arrayedList_reverse_worksWithEmptyList() {
        // ARRANGE
        Integer[] arr = {};

        // ACT
        ArrayedList<Integer> list = ArrayedList.create(arr);
        list.reverse();

        // ASSERT
        assertThat(list.toString()).isEqualTo("[]");
    }
    @Test
    public void arrayedList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
        // ARRANGE
        var list = new ArrayedList<Integer>();
        list.addFirst(1);
        list.addFirst(2);

        // ACT
        String value = list.toString();

        // ASSERT
        assertThat(value).isEqualTo("[2,1]");
    }

    @Test
    public void arrayedList_createFunction_worksWithEmptyList() {
        // ARRANGE
        Integer[] arr = {};

        // ACT
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ASSERT
        assertThat(list.toString()).isEqualTo("[]");
    }

    @Test
    public void arrayedList_createFunction_worksWithNonEmptyList() {
        // ARRANGE
        Integer[] arr = {1,2,3,4};

        // ACT
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ASSERT
        assertThat(list.toString()).isEqualTo("[1,2,3,4]");
    }

    @Test
    public void arrayedList_removeFirst_worksWithNonEmptyList() {
        // ARRANGE
        Integer[] arr = {1,2,3,4};
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ACT
        Integer a = list.removeFirst();
        Integer b = list.removeFirst();

        // ASSERT
        assertThat(a).isEqualTo(1);
        assertThat(b).isEqualTo(2);
    }

    @Test
    public void arrayedList_removeFirst_worksWithEmptyList() {
        // ARRANGE
        Integer[] arr = {};
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ACT

        // ASSERT
        assertThrows(NoSuchElementException.class, list::removeFirst);
    }

    @Test
    public void arrayedList_get_worksWithNonEmptyList() {
        // ARRANGE
        Integer[] arr = {4,3,2,1};
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ACT
        Integer a = list.get(2);

        // ASSERT
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void arrayedList_get_throwsNoSuchElementException() {
        // ARRANGE
        Integer[] arr = {1,2};
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ACT

        // ASSERT
        assertThrows(NoSuchElementException.class, () -> list.get(2));
    }

    @Test
    public void arrayedList_length_worksWithNonEmptyList() {
        // ARRANGE
        Integer[] arr = {4,3,2,1};
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ACT
        Integer a = list.length();

        // ASSERT
        assertThat(a).isEqualTo(4);
    }
    @Test
    public void arrayedList_length_worksWithEmptyList() {
        // ARRANGE
        Integer[] arr = {};
        ArrayedList<Integer> list = ArrayedList.create(arr);

        // ACT
        Integer a = list.length();

        // ASSERT
        assertThat(a).isEqualTo(0);
    }
}
