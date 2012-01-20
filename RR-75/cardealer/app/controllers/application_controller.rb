class ApplicationController < ActionController::Base
  protect_from_forgery

=begin
	def after_sign_in_path_for(user)
		expire_page(:controller => 'cars', :action => 'index')
		root_path
	end

	def after_sign_out_path_for(user)
		expire_page(:controller => 'cars', :action => 'index')
		root_path
	end
=end

end
