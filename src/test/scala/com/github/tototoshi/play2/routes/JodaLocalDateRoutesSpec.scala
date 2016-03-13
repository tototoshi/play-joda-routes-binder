package com.github.tototoshi.play2.routes

import org.joda.time._
import org.scalatest.{ FunSpec, ShouldMatchers }

class JodaLocalDateRoutesSpec extends FunSpec with ShouldMatchers {

  describe("JodaLocalDateRoutes") {

    describe("queryStringLocalDateBinder") {
      it("should bind query string to LocalDate") {
        val bindedLocalDate = JodaLocalDateRoutes.queryStringLocalDateBinder.bind(
          "date",
          Map("date" -> Seq("20130222"))
        )
        bindedLocalDate should be(Some(Right(new LocalDate(2013, 2, 22))))
      }

      it("should unbind LocalDate to query string") {
        val unbindedQueryString = JodaLocalDateRoutes.queryStringLocalDateBinder.unbind("date", new LocalDate(2013, 2, 22))
        unbindedQueryString should be("date=20130222")
      }
    }

    describe("pathLocalDateBinder") {
      it("should bind query string to DateTime") {
        val bindedLocalDate = JodaLocalDateRoutes.pathLocalDateBinder.bind("date", "20130222")
        bindedLocalDate should be(Right(new LocalDate(2013, 2, 22)))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaLocalDateRoutes.pathLocalDateBinder.unbind("date", new LocalDate(2013, 2, 22))
        unbindedQueryString should be("20130222")
      }
    }

  }
}

