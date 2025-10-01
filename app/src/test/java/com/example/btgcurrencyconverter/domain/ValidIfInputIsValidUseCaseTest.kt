package com.example.btgcurrencyconverter.domain

import org.junit.Test
import kotlin.test.assertEquals

class ValidIfInputIsValidUseCaseTest {

    @Test
    fun ValidIfInputIsValidUseCase_should_return_empty_when_input_is_empty(){

        val subject = ValidIfInputIsValidUseCase()
        val oldValue = "123"
        val input = ""
        val resultExpected = ""

        val realResult = subject.invoke(
            oldValue = oldValue,
            input = input
        )

        assertEquals(resultExpected,realResult)
    }

    @Test
    fun ValidIfInputIsValidUseCase_should_return_input_when_input_is_valid(){

        val subject = ValidIfInputIsValidUseCase()
        val oldValue = "123"
        val input = "1,5"
        val resultExpected = "1,5"

        val realResult = subject.invoke(
            oldValue = oldValue,
            input = input
        )

        assertEquals(resultExpected,realResult)
    }

    @Test
    fun ValidIfInputIsValidUseCase_should_return_oldValue_when_input_has_more_than_two_decimal_places(){

        val subject = ValidIfInputIsValidUseCase()
        val oldValue = "12,3"
        val input = "12,345"
        val resultExpected = oldValue

        val realResult = subject.invoke(
            oldValue = oldValue,
            input = input
        )

        assertEquals(resultExpected,realResult)
    }

    @Test
    fun ValidIfInputIsValidUseCase_should_return_oldValue_when_input_is_a_negative_number(){

        val subject = ValidIfInputIsValidUseCase()
        val oldValue = "12,3"
        val input = "-50"
        val resultExpected = oldValue

        val realResult = subject.invoke(
            oldValue = oldValue,
            input = input
        )

        assertEquals(resultExpected,realResult)
    }

    @Test
    fun ValidIfInputIsValidUseCase_should_return_oldValue_when_input_contains_nonNumeric_characters(){

        val subject = ValidIfInputIsValidUseCase()
        val oldValue = "12,3"
        val input = "123A"
        val resultExpected = oldValue

        val realResult = subject.invoke(
            oldValue = oldValue,
            input = input
        )

        assertEquals(resultExpected,realResult)
    }
}