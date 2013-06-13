/*
 * Copyright 2013 Toshiyuki Takahashi, Manabu Nakamura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.tototoshi.play2.routes

import play.api.mvc.{PathBindable, QueryStringBindable}
import org.joda.time.YearMonth
import org.joda.time.format.DateTimeFormat

trait JodaYearMonthRoutes { self: JodaYearMonthFormat =>

  implicit object queryStringYearMonthBinder extends QueryStringBindable.Parsing[YearMonth](
    YearMonth.parse(_, DateTimeFormat.forPattern(yearMonthFormat)),
    _.toString(yearMonthFormat),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.DateTime: %s".format(key, e.getMessage)
  )

  implicit object pathYearMonthBinder extends PathBindable.Parsing[YearMonth](
    YearMonth.parse(_, DateTimeFormat.forPattern(yearMonthFormat)),
    _.toString(yearMonthFormat),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.DateTime: %s".format(key, e.getMessage)
  )

}

object JodaYearMonthRoutes extends JodaYearMonthRoutes
  with DefaultJodaYearMonthFormat