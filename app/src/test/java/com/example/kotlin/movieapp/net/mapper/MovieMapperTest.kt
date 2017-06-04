package com.example.kotlin.movieapp.net.mapper

import com.example.kotlin.movieapp.fakes.Fakers
import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
internal class MovieMapperTest : Spek({
    var movieMapper = MovieMapper()

    describe("testing movie mapper") {

        given("the following MovieData to transform") {
            val expected = Fakers.generateMovieData()
            val actual = movieMapper.transform(expected)


            it("should equal movie values") {
                actual.id.should.be.equal(expected.id)
                actual.name.should.be.equal(expected.title)
            }
        }

        given("the following movie result data") {
            val expected = Fakers.generateMovieResultData()
            val actual = movieMapper.transform(expected)

            it("should eqal movie values") {
                actual.get(0).name.should.be.equal(expected.results.get(0).title)
                actual.get(0).id.should.be.equal(expected.results.get(0).id)
            }
        }
    }

})
