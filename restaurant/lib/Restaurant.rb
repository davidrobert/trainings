class Restaurant
	attr_accessor :name

	def initialize(name = "Restaurant Default")
		@name = name
	end

	def qualifies(score, msg="Thanks")
		puts "The score is #{score}. #{msg}"
	end

	def add_food(*foods)		
		@foods ||= Array.new
		for food in foods
			@foods << "[" + food.strip + "]" 
		end
		self		
	end	

	def del_food(food)
		@foods ||= Array.new
		# ...
		self
	end

	def to_s
		@foods ||= Array.new
		s = "Foods: "
		for food in @foods
			s += food.to_s + " "
		end
		s.strip
	end
end
