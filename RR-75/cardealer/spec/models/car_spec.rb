require 'spec_helper'

describe Car do

	include CarSpec 

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

	it "deveria calcular comissao" do
		@car.value = 32000
		@commission = 1600.0

		lambda {
			@car.calculate_commission
		}.should has_value(@commission)
	end	

	it "testando fabrica" do
		celta = Factory.build(:car)
		celta.name.should be == 'celta'
		celta.description.should be == 'vendo celta usado, ano 2001'
		celta.value.should be == 17000

		fox = Factory.build(:car, :name => 'fox', :description => 'vendo fox seminovo', :value => 30000)
		fox.name.should be == 'fox'
		fox.description.should be == 'vendo fox seminovo'
		fox.value.should be == 30000
	end

end
