package br.com.caelum.fj91.criacaodata.dsl

import java.util.Calendar

object Data {

  class Dia(val dia:Int) {
    def de(mes:Mes) = {
      new ConectorParaAno(dia, mes)
    }
  }

  class ConectorParaAno(val dia:Int, mes:Mes) {
    def de(ano:Int) = {
      val c = Calendar.getInstance()
      c.set(Calendar.DAY_OF_MONTH, dia)
      c.set(Calendar.MONTH, mes.numero)
      c.set(Calendar.YEAR, ano)
      c
    }
  }

  class Mes(val numero:Int)

  val Janeiro = new Mes(0)
  val Fevereiro = new Mes(1)
  val Março = new Mes(2)
  val Abril = new Mes(3)
  val Maio = new Mes(4)
  val Junho = new Mes(5)
  val Julho = new Mes(6)
  val Agosto = new Mes(7)
  val Setembro = new Mes(8)
  val Outubro = new Mes(9)
  val Novembro = new Mes(10)
  val Dezembro = new Mes(11)

  implicit def intToDia(dia:Int):Dia = {
     new Dia(dia)
  }
}