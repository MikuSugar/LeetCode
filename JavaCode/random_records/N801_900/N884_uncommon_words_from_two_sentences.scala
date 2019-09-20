package JavaCode.random_records.N801_900
import scala.collection.mutable.Map
import scala.collection.mutable.Set
/**
 * author:fangjie
 * time:2019/9/20
 */
class N884_uncommon_words_from_two_sentences {
  def uncommonFromSentences(A: String, B: String): Array[String] = {
      var c=A+" "+B
      var words=c.split(" ")
      var map:Map[String,Int]=Map()
      for(s<-words)map.put(s,map.getOrElse(s,0)+1)
      var res:Set[String]=Set()
      map.foreach(f=>if(f._2==1)res.add(f._1))
      res.toArray
  }
}

