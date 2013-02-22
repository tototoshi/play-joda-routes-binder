package com.github.tototoshi.play2.routes

import org.joda.time.{ LocalDate, DateTime }
import org.joda.time.format.DateTimeFormat
import java.net.URLEncoder
import play.api.mvc._

trait JodaFormat {
  val format: String
}

trait DefaultJodaFormat extends JodaFormat {
  val format = "yyyyMMdd"
}

trait JodaLocalDateRoutesImports { self: JodaFormat =>

  val format: String

  implicit object queryStringLocalDateBinder extends QueryStringBindable.Parsing[LocalDate] (
    dateString => DateTimeFormat.forPattern(format).parseLocalDate(dateString),
    _.toString(format),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.LocalDate: %s".format(key, e.getMessage)
  )

  implicit object pathLocalDateBinder extends PathBindable.Parsing[LocalDate] (
    dateString => DateTimeFormat.forPattern(format).parseLocalDate(dateString),
    _.toString(format),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.LocalDate: %s".format(key, e.getMessage)
  )

}
object JodaLocalDateRoutesImports extends JodaLocalDateRoutesImports with DefaultJodaFormat

trait JodaDateTimeRoutesImports { self: JodaFormat =>

  implicit object queryStringDateTimeBinder extends QueryStringBindable.Parsing[DateTime] (
    dateString => DateTimeFormat.forPattern(format).parseDateTime(dateString),
    _.toString(format),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.DateTime: %s".format(key, e.getMessage)
  )

  implicit object pathDateTimeBinder extends PathBindable.Parsing[DateTime] (
    dateString => DateTimeFormat.forPattern(format).parseDateTime(dateString),
    _.toString(format),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.DateTime: %s".format(key, e.getMessage)
  )

}

object JodaDateTimeRoutesImports extends JodaDateTimeRoutesImports with DefaultJodaFormat

trait JodaRoutesImports extends JodaLocalDateRoutesImports with JodaDateTimeRoutesImports with DefaultJodaFormat

object JodaRoutesImports extends JodaRoutesImports

