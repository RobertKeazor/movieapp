package com.example.kotlin.movieapp.ui.main

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`

@RunWith(JUnitPlatform::class)
internal class MainViewModelSpek : Spek ({
    //TODO This is not a actual ViewModelSpek. Replace with actual Spek, when real app code is introduced
    describe("mocking with mockito in spek") {

        given("mocking Iterable<T> and Iterator<T>") {
            val mockedIterable = Mockito.mock(Iterable::class.java)
            val mockedIterator = Mockito.mock(Iterator::class.java)
            `when`(mockedIterator.hasNext()).thenReturn(true, true, true, true, false)
            `when`(mockedIterator.next()).thenReturn(0,1,3,4)
            `when`(mockedIterable.iterator()).thenReturn(mockedIterator)
            val actual   = mockedIterable.joinToString(",")
            val expected = "0,1,3,4"

            it("should iterate mocked values") {
                actual.should.be.equal(expected)
            }
        }
    }
})
