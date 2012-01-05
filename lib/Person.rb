#encoding: utf-8

class Person
	attr_accessor :address 
	attr_accessor :age
	# attr_reader : ...
	# attr_writer : ...

	def initialize(name = "Legolas")
		self.name = name
	end

	def name
		@name
	end

	def name=(name)
		@name = name
	end

	def incrementAge
		@age ||= 0 # Similar: @age = @age || 0
		@age = @age + 1
	end

	def to_s
		"My name is #{@name}"
	end
end
