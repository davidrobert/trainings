#encoding: utf-8
require "./Franchise"
require "./Restaurant"

r = Restaurant.new "Domino's Pizza"
r.qualifies 1, "Bad!"
r.qualifies 10

class Restaurant
	def menu
		"Original"
	end
end

puts "r.menu = #{r.menu}"

class Restaurant
	def menu
		"New"
	end
end

r2 = Restaurant.new "Rubaiyat"
puts "r2.menu = #{r2.menu}"
puts "r.menu = #{r.menu}"

r.add_food "cookie"
r.add_food "milk", "hotdog", "pizza"
r.add_food "lemon", "orange"

puts r

r.close_bill :value => 42.35, :receipt =>
123456, :comment => "I like!"

f = Franchise.new "McDonald's"
f.add_restaurant r
f.add_restaurant r2

puts f

f2 = Franchise.new "Casa do Pão de Queijo"

f.report do |r|
	puts "Restaurante cadastrado: #{r.name}"
end

puts f2



