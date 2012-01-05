class Restaurant
	attr_accessor :name

	def self.report
		puts "Foram criados #{@@total} Restaurant"
	end

	def initialize(name = "Restaurant Default")
		puts "Criando um novo restaurante #{name}"
		@@total ||= 0
		@@total += 1
		@name = name
	end

	def qualifies(score, msg="Thanks")
		puts "The score is #{score}. #{msg}"
	end

	def add_food(*foods)		
		@foods ||= Array.new
		for food in foods
			@foods << "[#{food.strip}]" 
		end
		self		
	end	

	def del_food(food)
		@foods ||= Array.new
		# ...
		self
	end

	def close_bill(data)
		puts "Close bill:\n  Account closed at the value #{data[:value]} and receipt #{data[:receipt]}. Comment: #{data[:comment]}."			
	end

	def to_s
		@foods ||= Array.new
		s = "Foods: "
		@foods.each do |food|
			s += food.to_s + " "
		end
		s.strip
	end
end
