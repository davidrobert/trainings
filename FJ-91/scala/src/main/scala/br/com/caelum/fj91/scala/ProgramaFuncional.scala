package br.com.caelum.fj91.scala

object ProgramaFuncional {
  def main(args:Array[String]) {
    
    val p1 = new Produto("Banana", 10, 0.99)
    val p2 = new Produto("Maça", 100, 1.80)
    val p3 = new Produto("Tamarindo", 80, 3)
    val p4 = new Produto("Mexerica", 70, 1.20)
    
    val lista = List(p1, p2, p3, p4)
    
    println("Todos os produtos:")
    lista.foreach(println) // TODO implemente o toString para a saída ficar mais bonita
    
    println("Nomes dos produtos:")
    lista.foreach(p => println(p.nome))
    
    println("Produtos com preço maior que 1:")
    lista.filter(_.preco > 1).foreach(println)
    
  }
}