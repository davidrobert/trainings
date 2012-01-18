require 'spec_helper'

describe Car do

	before do
		@car = Car.new
	end

	it "deveria ser novo" do
		@car.should be_new
	end

	it "deveria ter uma comissao de 5% do valor" do
		@car.value = 32000
		@car.calculate_commission.should be == 1600.0
	end

	it "Moto?" do
		@car.should_not be_an_instance_of(Moto)
	end
	
end
