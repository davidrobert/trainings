require 'spec_helper'

describe CarsController do
	it "deveria instanciar um carro no index" do
		car_mock = mock_model(Car)

		Car.should_receive(:new).and_return(car_mock)
		
		get 'index'
		response.should be_success

		assigns[:car].should == car_mock
	end

	it "deveria lista os carros no index" do
		cars_mock = [mock_model(Car), mock_model(Car)]
		
		Car.should_receive(:all).and_return(cars_mock)

		get 'index'
		response.should be_success

		assigns[:cars].should == cars_mock
	end
end
