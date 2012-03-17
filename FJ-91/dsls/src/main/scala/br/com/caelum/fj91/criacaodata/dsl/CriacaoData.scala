package br.com.caelum.fj91.criacaodata.dsl

import java.util.Calendar
import java.text.SimpleDateFormat
import Data._

object CriacaoData {
  def main(args: Array[String]) {
    val data = 11 de Fevereiro de 1986

    println("Saída sem formatar: " + data)
    println("Saída formatada: " + new SimpleDateFormat("dd/MM/yyyy").format(data.getTime))
  }
}