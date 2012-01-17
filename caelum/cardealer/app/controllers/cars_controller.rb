class CarsController < ApplicationController
	def index
		@car = Car.new
		@cars = Car.all
	end

	def create
		car = Car.new(params[:car])
		car.save
		redirect_to :action => "index"
	end
end
