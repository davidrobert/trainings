module ClassMethods
	def de_classe
		puts "${self}"
		# classe
	end
end

module RestauranteDetalhes
	def nome
		"oi"
	end

	def self.included(classe)
		class << classe
			include ClassMethods
		end
	end
end

module Comentavel
	def adiciona_comentario(com)
		@comentarios ||= []
		@comentarios << com
	end

	def comentarios
		@comentarios
	end
end

# Duas maneira de fazer a mesma coisa

class Restaurante1
	extend RestauranteDetalhes
	include Comentavel
end

class Restaurante2
	include Comentavel

	class << self
		include RestauranteDetalhes
	end
end

r1 = Restaurante1.new
r2 = Restaurante2.new

r1.adiciona_comentario "ABC" 	
r1.adiciona_comentario "DEF" 	

r2.adiciona_comentario "ABC" 	
r2.adiciona_comentario "DEF" 	

puts r1.comentarios
puts r2.comentarios



