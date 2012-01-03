require "./Restaurant"

r = Restaurant.new
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

r2 = Restaurant.new
puts "r2.menu = #{r2.menu}"
puts "r.menu = #{r.menu}"

r.add_food "cookie"
r.add_food "milk", "hotdog", "pizza"
r.add_food "lemon", "orange"

puts r
