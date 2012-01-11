module ApplicationHelper
	def main_menu
		menu = %w(client qualification restaurant)
		main_menu = "<ul>"
		menu.each do |item|
			main_menu << "<li>" + link_to(item, :controller => item.pluralize) + "</li>"
		end
		main_menu << "</ul>"
		raw main_menu
	end

	def format_value(number)
		number_to_currency(number, :unit => "R$ ", :separator => ",", :delimiter => ".")
	end
end
