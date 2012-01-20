class ApplicationController < ActionController::Base
  protect_from_forgery

	# Este exemplo nao eh muito eficiente pois o cache 
	# expira sempre que alguem faz login ou logout.
	# Isso serve apenas para exemplificar a utilizacao do cache.

	def after_sign_in_path_for(user)
		expire_page('/')
		root_path
	end

	def after_sign_out_path_for(user)
		expire_page('/')
		root_path
	end

end
