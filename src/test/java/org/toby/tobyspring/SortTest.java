package org.toby.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class SortTest {
    Sort sort;
    @BeforeEach
    void beforeEach() {
        //  given 준비
         sort = new Sort();
    }

    @Test
    void sort() {
        //  when 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        //  then 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3times() {
        List<String> list = sort.sortByLength(Arrays.asList("aa","ccc", "b"));

        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
        List<String> list = sort.sortByLength(Arrays.asList("b","aa","ccc"));

        Assertions.assertThat(list).isEqualTo(List.of("b","aa","ccc"));
    }

}