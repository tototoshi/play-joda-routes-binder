package com.github.tototoshi.play2.routes

import org.scalatest.FunSpec
import org.scalatest.matchers._
import org.joda.time._

class JodaDateTimeRoutesSpec extends FunSpec with ShouldMatchers {

  describe("JodaDateTimeRoutes") {

    describe("queryStringDateTimeBinder") {
      it("should bind query string to DateTime") {
        val bindedDateTime = JodaDateTimeRoutes.queryStringDateTimeBinder.bind(
          "date",
          Map("date" -> Seq("20130222"))
        )
        bindedDateTime should be(Some(Right(new DateTime(2013, 2, 22, 0, 0, 0))))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaDateTimeRoutes.queryStringDateTimeBinder.unbind("date", new DateTime(2013, 2, 22, 0, 0, 0))
        unbindedQueryString should be("date=20130222")
      }
    }

    describe("pathDateTimeBinder") {
      it("should bind query string to DateTime") {
        val bindedDateTime = JodaDateTimeRoutes.pathDateTimeBinder.bind("date", "20130222")
        bindedDateTime should be(Right(new DateTime(2013, 2, 22, 0, 0, 0)))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaDateTimeRoutes.pathDateTimeBinder.unbind("date", new DateTime(2013, 2, 22, 0, 0, 0))
        unbindedQueryString should be("20130222")
      }
    }

  }
}

