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
import org.joda.time.MonthDay
import org.joda.time.format.DateTimeFormat

trait JodaMonthDayRoutes { self: JodaMonthDayFormat =>

  implicit object queryStringMonthDayBinder extends QueryStringBindable.Parsing[MonthDay](
    MonthDay.parse(_, DateTimeFormat.forPattern(monthDayFormat)),
    _.toString(monthDayFormat),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.MonthDay: %s".format(key, e.getMessage)
  )

  implicit object pathMonthDayBinder extends PathBindable.Parsing[MonthDay](
    MonthDay.parse(_, DateTimeFormat.forPattern(monthDayFormat)),
    _.toString(monthDayFormat),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.MonthDay: %s".format(key, e.getMessage)
  )

}

object JodaMonthDayRoutes extends JodaMonthDayRoutes
  with DefaultJodaMonthDayFormat
