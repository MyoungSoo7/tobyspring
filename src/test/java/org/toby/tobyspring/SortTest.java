package org.toby.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class SortTest {

    @Test
    void sort() {
        //  given 준비
        Sort sort = new Sort();

        //  when 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        //  then 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

}