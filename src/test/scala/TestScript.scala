import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.http.Predef._

class Gatling extends Simulation {
//  val httpConf = http.baseURLs("http://localhost:8080","http://localhost:8081")
  val httpConf = http.baseURLs("http://localhost:8080")


  def providerId(plural:Boolean) = if(plural) s"providerIds=332" else s"providerId=332"
  val csv1: RecordSeqFeederBuilder[String] = csv("shorter.csv")

  val scn = scenario("Comments").repeat(500,"comments") {
    val feeder = csv1.random
    feed(feeder)
      .exec(http("comments")
        .post("/api/property/${hotel_id}").headers(Map("Content-Type" -> """application/json""")).body(StringBody(
          """
            | {
            |  "reviews": {
            |    "demographic": {
            |        "providerIds": [
            |        332,
            |        3038
            |      ]
            |    },
            |    "commentary": {
            |      "page": {
            |        "pageSize": 20,
            |        "pageNumber": 1
            |      },
            |      "isOnlyCurated": 0,
            |      "sorting": 1,
            |      "demographicId": 0,
            |      "providerIds": [
            |        332,
            |        3038
            |      ]
            |    },"cumulative": {
            |      "providerIds": [
            |        332,
            |        3038
            |      ]
            |    }
            |  },
            |  "context": {
            |    "locale": "en-us",
            |    "noCache":true
            |  }
            |}
          """.stripMargin)))
  }

  setUp( // 11
    scn.inject(atOnceUsers(50)) // 12
  ).protocols(httpConf)

}