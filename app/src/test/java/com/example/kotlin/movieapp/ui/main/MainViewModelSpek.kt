package com.example.kotlin.movieapp.ui.main

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class MainViewModelSpek : Spek ({
    val viewModel = MainViewModel()

    context("Testing our hello world") {

        it("should have our test strings") {
            assertEquals(viewModel.firstName, "Kotlin 100")
        }
    }
})
