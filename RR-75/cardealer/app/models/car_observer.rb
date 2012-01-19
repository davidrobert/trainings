class CarObserver < ActiveRecord::Observer

	# Toda vez que um objeto Car for criado eh executado este metodo
	def after_create(car)
		Notifier.new_car(car, "davidrobert@gmail.com").deliver
	end
end
