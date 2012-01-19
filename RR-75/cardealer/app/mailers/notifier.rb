class Notifier < ActionMailer::Base
  default :from => "davidrobert@gmail.com"

	# Para cada metodo vai ter uma view dentro 
	# do diretorio app/views/notifier/ 
	# Ex.: app/views/notifier/new_car.html.erb

	def new_car(car, email)
		@car = car
		mail(:to => email, :subject => car.name)
	end
end
