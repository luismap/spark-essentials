package playground

import org.apache.spark.sql.SparkSession

object Numbers extends  App {
  val ss = SparkSession.builder()
    .appName("Numbers-csv")
    .config("spark.master", "local[2]")
    .getOrCreate()
  import ss.implicits._

  val numbers = ss
    .read
    .option("inferSchema", "true")
    .option("header", "true")
    .csv("src/main/resources/data/numbers.csv")

  numbers.show(10)

  numbers.sort($"numbers".desc).explain()
}
