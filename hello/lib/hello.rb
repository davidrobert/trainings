# The famous Hello World
puts "Hello World!"

=begin
	Block comment (not usual!)
	Block comment (not usual!)
	Block comment (not usual!)
=end

name = "Alpha"
puts "This name is #{name}"

puts name.class

puts name.upcase
puts name

# Comportamento mutavel terminado com o operador "!"
puts name.upcase!
puts name

# Symbols are also text (use the character ":")
puts :name

# Types
i = 0
3.times { 
	i = i + 1
	puts "> #{i} - #{name}" 
}

# Boolean comparisson
puts "2 > 0 = #{2 > 0}"
puts "2 < 0 = #{2 < 0}"
puts "2 == 2 = #{2 == 2}"
puts "2 != 2 = #{2 != 2}"

# Ranges
puts (0..4).each { |x| puts x }  
puts ('a'..'d').each { |x| puts x }  

v = nil
if (v)
	puts "v is not nil"
else
	puts "v is nil"
end

for i in (1..5)
	case i
		when 1..3
			puts "#{i} : 1..3"
		when 4
			puts "#{i} : 4"
		when 5
			puts "#{i} : 5"
	end
end

# Create string
f = %(the one ring)

# Create Regexp
r = /*ring/

puts f =~ r

