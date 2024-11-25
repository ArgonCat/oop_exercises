/*
 * Copyright 2024 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, J. Jinkinson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.jj625.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class LinkListTest {

  @Test
  public void linkList_toStringIsEmptyList_whenListEmpty() {
    // ARRANGE
    var empty = new LinkList<Integer>();

    // ACT
    String value = empty.toString();

    // ASSERT
    assertThat(value).isEqualTo("[]");
  }



  @Test
  public void linkList_toStringIsSingleItem_whenListContainsOneItem() {
    // ARRANGE
    LinkList<Integer> list = new LinkList<Integer>();
    list.addFirst(1);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[1]");
  }

  @Test
  public void linkList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
    // ARRANGE
    var list = new LinkList<Integer>();
    list.addFirst(1);
    list.addFirst(2);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[2,1]");
  }

  @Test
  public void linkList_createFunction_worksWithEmptyList() {
    // ARRANGE
    Integer[] arr = {};

    // ACT
    LinkList<Integer> list = LinkList.create(arr);

    // ASSERT
    assertThat(list.toString()).isEqualTo("[]");
  }
  @Test
  public void linkList_reverse_worksWithNonEmptyList() {
    // ARRANGE
    Integer[] arr = {1,2,3};

    // ACT
    LinkList<Integer> list = LinkList.create(arr);
    list.reverse();

    // ASSERT
    assertThat(list.toString()).isEqualTo("[3,2,1]");
  }
  @Test
  public void linkList_reverse_worksWithEmptyList() {
    // ARRANGE
    Integer[] arr = {};

    // ACT
    LinkList<Integer> list = LinkList.create(arr);
    list.reverse();

    // ASSERT
    assertThat(list.toString()).isEqualTo("[]");
  }

  @Test
  public void linkList_createFunction_worksWithNonEmptyList() {
    // ARRANGE
    Integer[] arr = {1,2,3,4};

    // ACT
    LinkList<Integer> list = LinkList.create(arr);

    // ASSERT
    assertThat(list.toString()).isEqualTo("[1,2,3,4]");
  }

  @Test
  public void linkList_removeFirst_worksWithNonEmptyList() {
    // ARRANGE
    Integer[] arr = {1,2,3,4};
    LinkList<Integer> list = LinkList.create(arr);

    // ACT
    Integer a = list.removeFirst();
    Integer b = list.removeFirst();

    // ASSERT
    assertThat(a).isEqualTo(1);
    assertThat(b).isEqualTo(2);
  }

  @Test
  public void linkList_removeFirst_worksWithEmptyList() {
    // ARRANGE
    Integer[] arr = {};
    LinkList<Integer> list = LinkList.create(arr);

    // ACT

    // ASSERT
    assertThrows(NoSuchElementException.class, list::removeFirst);
  }

  @Test
  public void linkList_get_worksWithNonEmptyList() {
    // ARRANGE
    Integer[] arr = {4,3,2,1};
    LinkList<Integer> list = LinkList.create(arr);

    // ACT
    Integer a = list.get(2);

    // ASSERT
    assertThat(a).isEqualTo(2);
  }

  @Test
  public void linkList_get_throwsNoSuchElementException() {
    // ARRANGE
    Integer[] arr = {1,2};
    LinkList<Integer> list = LinkList.create(arr);

    // ACT

    // ASSERT
    assertThrows(NoSuchElementException.class, () -> list.get(2));
  }

  @Test
  public void linkList_length_worksWithNonEmptyList() {
    // ARRANGE
    Integer[] arr = {4,3,2,1};
    LinkList<Integer> list = LinkList.create(arr);

    // ACT
    Integer a = list.length();

    // ASSERT
    assertThat(a).isEqualTo(4);
  }
  @Test
  public void linkList_length_worksWithEmptyList() {
    // ARRANGE
    Integer[] arr = {};
    LinkList<Integer> list = LinkList.create(arr);

    // ACT
    Integer a = list.length();

    // ASSERT
    assertThat(a).isEqualTo(0);
  }
}
