/*
 * Copyright 2012 Toshiyuki Takahashi
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

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import java.net.URLEncoder
import play.api.mvc._

trait JodaLocalDateRoutes { self: JodaFormat =>

  val format: String

  implicit object queryStringLocalDateBinder extends QueryStringBindable.Parsing[LocalDate](
    dateString => DateTimeFormat.forPattern(format).parseLocalDate(dateString),
    _.toString(format),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.LocalDate: %s".format(key, e.getMessage)
  )

  implicit object pathLocalDateBinder extends PathBindable.Parsing[LocalDate](
    dateString => DateTimeFormat.forPattern(format).parseLocalDate(dateString),
    _.toString(format),
    (key: String, e: Exception) => "Cannot parse parameter %s as org.joda.time.LocalDate: %s".format(key, e.getMessage)
  )

}
object JodaLocalDateRoutes extends JodaLocalDateRoutes
  with DefaultJodaFormat

