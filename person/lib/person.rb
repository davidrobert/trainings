require "./Person"

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


