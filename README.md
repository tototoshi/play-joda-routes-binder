# play-joda-routes-binder

QueryString / Path Binder for Play 2.x

## Usage

Add routesImport to your Build.scala

```scala
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
  implicit val myJodaRoutes = new JodaRoutes {
    override val format: String = "yyMMdd"
  }
}
```

```scala
routesImport += "example.MyRoutes._"
```
