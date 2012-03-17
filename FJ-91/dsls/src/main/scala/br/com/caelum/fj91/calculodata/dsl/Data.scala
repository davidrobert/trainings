package br.com.caelum.fj91.calculodata.dsl

import java.util.Calendar

class Data(val data: Calendar) {
  import Data.Conjuncao

  private var ultimo = 0;

  def mais(num: Int) = { ultimo = num; this }
  def menos(num: Int) = { ultimo = -num; this }

  def meses = { data.add(Calendar.MONTH, ultimo); this }
  def meses(e: Conjuncao): Data = meses
  def mês = meses
  def mês(e: Conjuncao): Data = meses

  def anos = { data.add(Calendar.YEAR, ultimo); this }
  def anos(e: Conjuncao): Data = anos
  def ano = anos
  def ano(e: Conjuncao): Data = anos

  def dias = { data.add(Calendar.DAY_OF_MONTH, ultimo); this }
  def dias(e: Conjuncao): Data = dias
  def dia = dias
  def dia(e: Conjuncao): Data = dias

  override def toString = "%1$Td/%1$Tm/%1$TY" format data
}
object Data {
  class Conjuncao
  val e = new Conjuncao

  def Hoje = new Data(Calendar.getInstance)
  def Amanhã = Hoje mais 1 dia
  def Ontem = Hoje menos 1 dia

  def hoje = Hoje
  def amanhã = Amanhã
  def ontem = Ontem
}