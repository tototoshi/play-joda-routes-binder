package com.github.tototoshi.play2.routes

import org.joda.time.MonthDay
import org.scalatest.{ FunSpec, Matchers }

class JodaMonthDayRoutesSpec extends FunSpec with Matchers {

  describe("JodaMonthDayRoutes") {
    describe("queryStringLocalDateBinder") {
      it("should bind query string to LocalDate") {
        val bindedMonthDay = JodaMonthDayRoutes.queryStringMonthDayBinder.bind(
          "date",
          Map("date" -> Seq("0613"))
        )
        bindedMonthDay should be(Some(Right(new MonthDay(6, 13))))
      }

      it("should unbind LocalDate to query string") {
        val unbindedQueryString = JodaMonthDayRoutes.queryStringMonthDayBinder.unbind("date", new MonthDay(6, 13))
        unbindedQueryString should be("date=0613")
      }
    }

    describe("pathLocalDateBinder") {
      it("should bind query string to DateTime") {
        val bindedMonthDay = JodaMonthDayRoutes.pathMonthDayBinder.bind("date", "0613")
        bindedMonthDay should be(Right(new MonthDay(6, 13)))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaMonthDayRoutes.pathMonthDayBinder.unbind("date", new MonthDay(6, 13))
        unbindedQueryString should be("0613")
      }
    }
  }

}
