package com.github.tototoshi.play2.routes

import org.joda.time.YearMonth
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class JodaYearMonthRoutesSpec extends AnyFunSpec with Matchers {

  describe("JodaYearMonthRoutes") {
    describe("queryStringLocalDateBinder") {
      it("should bind query string to LocalDate") {
        val bindedYearMonth = JodaYearMonthRoutes.queryStringYearMonthBinder.bind(
          "date",
          Map("date" -> Seq("201302"))
        )
        bindedYearMonth should be(Some(Right(new YearMonth(2013, 2))))
      }

      it("should unbind LocalDate to query string") {
        val unbindedQueryString = JodaYearMonthRoutes.queryStringYearMonthBinder.unbind("date", new YearMonth(2013, 2))
        unbindedQueryString should be("date=201302")
      }
    }

    describe("pathLocalDateBinder") {
      it("should bind query string to DateTime") {
        val bindedYearMonth = JodaYearMonthRoutes.pathYearMonthBinder.bind("date", "201302")
        bindedYearMonth should be(Right(new YearMonth(2013, 2)))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaYearMonthRoutes.pathYearMonthBinder.unbind("date", new YearMonth(2013, 2))
        unbindedQueryString should be("201302")
      }
    }
  }

}
