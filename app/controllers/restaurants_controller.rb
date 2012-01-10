class RestaurantsController < ApplicationController
	def index
		@restaurants = Restaurant.order("name")
	end

	def show
		@restaurant = Restaurant.find(params[:id])
	end

	def new
		@restaurant = Restaurant.new
	end

	def create
		@restaurant = Restaurant.new params[:restaurant]
		if @restaurant.save
			redirect_to(:action => "show", :id => @restaurant)
		else
			render :action => "new"
		end
	end

	def edit
		@restaurant = Restaurant.find(params[:id])
	end

	def update
		@restaurant = Restaurant.find(params[:id])
		if @restaurant.update_attributes(params[:restaurant])
			redirect_to(:action => "show", :id => @restaurant)
		else
			render :action => "edit"
		end
	end

	def destroy
		@restaurant = Restaurant.find(params[:id])
		@restaurant.destroy

		redirect_to(:action => "index")
	end
end
