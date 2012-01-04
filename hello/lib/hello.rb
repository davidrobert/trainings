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

# -- Types --
i = 0
3.times { 
	i = i + 1
	puts "> #{i} - #{name}" 
}

# -- Boolean comparisson --
puts "2 > 0 = #{2 > 0}"
puts "2 < 0 = #{2 < 0}"
puts "2 == 2 = #{2 == 2}"
puts "2 != 2 = #{2 != 2}"

# -- Ranges --
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

# -- Create string --
f = %(the one ring)

# -- Create Regexp --
#r = /*ring/
#
#puts f =~ r


# -- Sort by --
a = [ 
	{:name => 'ZZ', :value => 12}, 
	{:name => 'AA', :value => 10},
	{:name => 'DD', :value => 11}, 
]

a.each do |s|
	puts s[:name]
end

a.sort_by{ |s| s[:name] }.each do |s|
	puts s[:name]
end

# -- Exceptions --
def verify_age(age)
	if age < 18
		raise ArgumentError, "Menor de idade!"
	end
end

begin
	verify_age 10
rescue ArgumentError => e
	puts e.message
end

class InvalidAge < Exception
	attr_accessor :age
	def initialize(age)
		@age = age
	end
end

def verify_age2(age)
	if age < 18		
		e = InvalidAge.new age
		raise e, "Menor de idade!!"
	end
end

begin
	verify_age2 10
rescue InvalidAge => e
	puts "#{e.message} - Age: #{e.age}"
end

