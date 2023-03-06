package com.eddicorp.examples.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("우리회사 핵심 기술 사칙연산 모듈")
class FourFundamentalArithmeticOperationsTest {

    @Test
    void test() {
        // given
        final FourFundamentalArithmeticOperations sut = new FourFundamentalArithmeticOperations();

        // when
        final long result = sut.add(10, 20);

        // then
        assertEquals(30, result);
    }

    @DisplayName("분모가 0이면 예외가 발생한다")
    @Test
    void testDivideByZero() {
        // given
        final FourFundamentalArithmeticOperations sut = new FourFundamentalArithmeticOperations();

        // when
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    sut.div(10, 0);
                }
        );
    }
}
