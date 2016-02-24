/*
import scala.concurrent.Future
import scala.io.Source

/**
  * Created by alynch on 1/21/2016 AD.
  */
object thinger extends App {
  val a: Map[Long, List[Long]] = Source.fromFile("/Users/alynch/git/untitled1/src/main/resources/out.csv").getLines().map(s => {
    if(s == "hotel_id") 0 else s.toLong
  }).toList.groupBy(k => k)

  private val totalLeft: Long = a.values.foldLeft(0L)(_ + _.size)
  private val avg = totalLeft / a.size
  val b =0

  val x: Future[String] = Future {""}
  private val map: Future[Int] = x.map(s => s.length)
}
*/
