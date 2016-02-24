import scala.concurrent.Future

/**
  * Created by alynch on 2/23/2016 AD.
  */
object somethreads extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  Future {
    Thread.sleep(1000)
    println("Hi")

  }

  Future {
    Thread.sleep(1000)
    println("Hi")

  }


  Future {
    Thread.sleep(1000)
    println("Hi")

  }


  Future {
    Thread.sleep(1000)
    println("Hi")

  }

  Future {
    Thread.sleep(1000)
    println("Hi")

  }

  Future {
    Thread.sleep(1000)
    println("Hi")

  }


  Future {
    Thread.sleep(1000)
    println("Hi")

  }


  Future {
    Thread.sleep(1000)
    println("Hi")
  }




  Thread.sleep(Long.MaxValue)

}
