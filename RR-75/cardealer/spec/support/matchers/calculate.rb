
#crie ess módulo com a classe Calculate
module CarSpec

	class Calculate
	
		def initialize(commission)
			@commission = commission
		end

		def matches?(bloco)
			bloco.call == @commission
		end

		def failure_message_for_should
			"valor da comissao nao esta igual : #{@commission} " 
		end

		def failure_message_for_should_not
			"valor da comissao esta igual : #{@commission} "
		end
	end

	def has_value(commission)
		Calculate.new(commission)
	end

end
