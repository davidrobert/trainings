class CarSweeper < ActionController::Caching::Sweeper
	observe Car

	def after_save(car)
		clear_car_cache(car)
	end

	def after_destroy(car)
		clear_car_cache(car)
	end

	private
	def clear_car_cache(car)
		expire_page(:controller => 'car', :action => 'index')
	end
end
