require "spec_helper"

describe Notifier do
	describe "email do carro novo" do
		car = Factory.create(:car)

		let(:mail) { Notifier.new_car(car, "davidrobert@gmail.com") }

		it "cabecalho" do
			mail.subject.should eq(car.name)
			mail.to.should eq(["david@camargo.eti.br"])
			mail.from.should eq(["davidrobert@gmail.com"])
		end

		it "exibe o corpo da mensagem" do
			mail.body.encoded.should match("Novo carro cadastrado!")
			mail.body.encoded.should match(car.name)
			mail.body.encoded.should match(car.description)
			mail.body.encoded.should match(car.value.to_s)
		end

	end
end
