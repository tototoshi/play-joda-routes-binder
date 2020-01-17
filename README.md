# play-joda-routes-binder

[![Build Status](https://travis-ci.org/tototoshi/play-joda-routes-binder.png)](https://travis-ci.org/tototoshi/play-joda-routes-binder)

QueryString / Path Binder for Play 2.x

## Usage

Add dependency and routesImport to your Build.scala

```scala
libraryDependencies ++= Seq(
  // for Play 2.8
  "com.github.tototoshi" %% "play-joda-routes-binder" % "1.4.0"
  // for Play 2.7
  "com.github.tototoshi" %% "play-joda-routes-binder" % "1.3.0"
  // for Play 2.6
  "com.github.tototoshi" %% "play-joda-routes-binder" % "1.2.0"
  // for Play 2.5
  // "com.github.tototoshi" %% "play-joda-routes-binder" % "1.1.0"
)

routesImport += "com.github.tototoshi.play2.routes.JodaRoutes._"
```

Now you can bind query string and path parameters to LocalDate and DateTime.
```
GET     /list                 controllers.Application.index(date: org.joda.time.LocalDate)
GET     /entry/$date<[0-9]+>  controllers.Application.entry(date: org.joda.time.LocalDate)
```

Default format of LocalDate and DateTime is 'yyyyMMdd'. You can override this behavior if you don't like it.
Add the customized binder to your Build.scala

```scala
package example

object MyRoutes {
  val myJodaRoutes = new com.github.tototoshi.play2.routes.JodaRoutes {
    override val format: String = "yyMMdd"
  }
}
```

```scala
routesImport += "example.MyRoutes.myJodaRoutes._"
```


## License
[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)
