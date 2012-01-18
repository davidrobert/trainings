require 'spec_helper'

describe Car do
	it "deveria ser novo" do
		Car.new.should be_new
	end

	it "deveria ter uma comissao de 5% do valor" do
		c = Car.new
		c.value = 32000
		c.calculate_commission.should be == 1600.0
	end

	it "Moto?" do
		Car.new.should_not be_an_instance_of(Moto)
	end
	
end
