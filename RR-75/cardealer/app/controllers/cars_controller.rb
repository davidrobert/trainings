class CarsController < ApplicationController
	def index
		@car = Car.new
		@cars = Car.all
	end

	def create
		car = Car.new(params[:car])
		car.save
		redirect_to :action => "index"

		# Apesar do metodo new_car ser de instancia, o 
		# comportamento dos metodos das classes que herdam 
		# de ActionMailer tem um comportamento distinto. 
		# Por isso o metodo eh chamado sem instanciar a classe
		Notifier.new_car(car, "davidrobert@gmail.com").deliver

	end
end
