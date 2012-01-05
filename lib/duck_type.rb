#encoding: utf-8
$: << File.expand_path(".")

class Franchise
	def info
		puts "Restaurante faz parte da franquia"
	end
end 

class Restaurant < Franchise
	def info
		super
		puts "Restaurante Fogo de Chao"
	end
end

def informa(franquia)
	franquia.info
end

restaurant = Restaurant.new
restaurant.info

informa restaurant
