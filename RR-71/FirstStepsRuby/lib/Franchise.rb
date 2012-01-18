#encoding: utf-8

require 'observer'

class Franchise
	include Observable

	attr_accessor :name

	def initialize(name = "")
		@name = name
	end

	def add_restaurant(*restaurants)
		@restaurants ||= Array.new
		for r in restaurants
			@restaurants << r
			add_observer(r, :update_score)
		end
	end

	def report
		@restaurants ||= Array.new
		
		@restaurants.each do |restaurant|
			yield restaurant
		end
	end

	# Method to design pattern Observer
	def update_scores
		changed
		notify_observers(self)
	end

	def to_s
		@restaurants ||= Array.new
		s = "Franchise: #{@name}"

		if @restaurants.size == 0
			return s
		end

		s += "\n  Restaurants:"
		@restaurants.each do |restaurant|
			s += "\n    #{restaurant.name}"  
		end
		s.strip
	end	
end
