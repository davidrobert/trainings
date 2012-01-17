class Car < ActiveRecord::Base
	def new?
		true
	end

	def calculate_commission
		value * 0.05
	end
end
