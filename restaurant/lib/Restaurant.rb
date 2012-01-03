class Restaurant
	attr_accessor :name

	def initialize(name = "Restaurant Default")
		@name = name
	end

	def qualifies(score, msg="Thanks")
		puts "The score is #{score}. #{msg}"
	end
end
