package com.github.tototoshi.play2.routes

import org.joda.time._
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class JodaDateTimeRoutesSpec extends AnyFunSpec with Matchers {

  describe("JodaDateTimeRoutes") {

    describe("queryStringDateTimeBinder") {
      it("should bind query string to DateTime") {
        val bindedDateTime = JodaDateTimeRoutes.queryStringDateTimeBinder.bind(
          "date",
          Map("date" -> Seq("20130222000000"))
        )
        bindedDateTime should be(Some(Right(new DateTime(2013, 2, 22, 0, 0, 0))))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaDateTimeRoutes.queryStringDateTimeBinder.unbind("date", new DateTime(2013, 2, 22, 0, 0, 0))
        unbindedQueryString should be("date=20130222000000")
      }
    }

    describe("pathDateTimeBinder") {
      it("should bind query string to DateTime") {
        val bindedDateTime = JodaDateTimeRoutes.pathDateTimeBinder.bind("date", "20130222000000")
        bindedDateTime should be(Right(new DateTime(2013, 2, 22, 0, 0, 0)))
      }

      it("should unbind DateTime to query string") {
        val unbindedQueryString = JodaDateTimeRoutes.pathDateTimeBinder.unbind("date", new DateTime(2013, 2, 22, 0, 0, 0))
        unbindedQueryString should be("20130222000000")
      }
    }

  }
}

