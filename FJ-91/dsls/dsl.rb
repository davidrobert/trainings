class Fixnum
	def reais
		Dinheiro.new(:reais, self)
	end
	
	def dolares
		Dinheiro.new(:dolares, self)
	end
end

class Dinheiro

	attr_reader :moeda
	attr_reader :valor

	def initialize(moeda, valor)
		@moeda = moeda
		@valor = valor
	end
	
	def + (outro_dinheiro)
		valor_real = 1.50
		if(@moeda != outro_dinheiro.moeda)
			if(@moeda == :reais)
				taxa = valor_real 
			else
				taxa = 1 / valor_real
			end
		else
			taxa = 1			
		end
		valor = @valor + outro_dinheiro.valor * taxa
		Dinheiro.new(@moeda , valor)
	end 
	
	def to_s
		"#{@valor} - #{@moeda}"	
	end
end 

total_1 = 5.reais + 3.reais
puts total_1 

total_2 = 10.reais + 3.dolares
puts total_2

total_3 = 10.dolares + 3.dolares
puts total_3

total_4 = 5.dolares + 3.reais
puts total_4