class CarsController < ApplicationController

	# Lembrete: por padrão o ambiente de desenvolvimento do Rails
	# deixa o cache desabilitado#

	# Este exemplo nao eh muito eficiente pois o cache 
	# expira sempre que alguem faz login ou logout
	# Isso serve apenas para exemplificar a utilizacao do cache.

	# Indica para o Rails que a pagina de index seja cacheada 
	# desta maneira dentro da raiz, no diretorio public, sera criado 
	# um arquivo index.html
	# Exemplo: .../public/index.html
	caches_page :index

	def index
		@car = Car.new
		@cars = Car.all
	end

	def create
		car = Car.new(params[:car])
		car.save

		# Indica que o cache deve expirar, ou seja, a proxima requisição para
		# index ira gerar um novo cache
		expires_page(:controller => "cars", :action => "index")

		redirect_to :action => "index"

		# Apesar do metodo new_car ser de instancia, o 
		# comportamento dos metodos das classes que herdam 
		# de ActionMailer tem um comportamento distinto. 
		# Por isso o metodo eh chamado sem instanciar a classe
		Notifier.new_car(car, "davidrobert@gmail.com").deliver

	end
end
