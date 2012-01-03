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
