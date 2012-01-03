class Person
	attr_accessor :address 

	def initialize(name = "Legolas")
		self.name = name
	end

	def name
		@name
	end

	def name=(name)
		@name = name
	end
end
