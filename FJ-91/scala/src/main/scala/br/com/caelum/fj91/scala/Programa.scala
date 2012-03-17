package br.com.caelum.fj91.scala
import javax.swing._

object Programa {
  def main(args:Array[String]) {
    
    val p = new Produto("Melancia", 100, 3.90)

    println("Dados do produto:")
    println(p.nome)
    println(p.quantidade)
    println(p.preco)

    println("Atualizando quantidade em Scala:")
    p.quantidade = 120
    println(p.quantidade)
    
    println("Atualizando preço com Java:")
    val atualizador = new AtualizadorDePreco(1.2)
    atualizador.atualiza(p)

    JOptionPane.showMessageDialog(null, "Preço final: " + p.preco)
    
  }
}
