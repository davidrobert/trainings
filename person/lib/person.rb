#encoding: utf-8
$: << File.expand_path(".")

require "Person"

p = Person.new
puts p.name()

p = Person.new("Astrogildo")
puts p.name()

p.name = "Joca"
puts p.name

p.name = "Gandalf"
puts p.name

p.address = "Moria"
puts p.address

puts p.incrementAge

fulano = Person.new("Fulano")

# Adicionando metodo em um objeto especifico

def fulano.sleep
	puts "Zzzz..."
end

fulano.sleep

# Nao eh possivel chamar o metodo sleep em
# outro objeto
# Exemplo: p.sleep

# Eh possivel sobreescrever um metodo da
# classe dinamicamente
def fulano.incrementAge
	@age = @age || 0
	@age = @age + 200
end

puts fulano.incrementAge

puts fulano

# -- Dynamic Class --

Person2 = Class.new {
	def to_s
		"Person2"
	end
}

p2 = Person2.new
puts p2

class Person3 < Object
	def walk
		puts "Walking..."
	end
end

p3 = Person3.new

# -- Metodo de class -- 
def Person3.number
	9999	
end

# -- Metodo de um objeto especifico --
def p3.number
	1000
end

p3.walk
puts p3.number

p4 = Person3.new
begin
	puts p4.number
rescue NameError => e
	puts "p4 nao tem o metodo 'number'"
end
	
puts Person3.number
