#encoding: utf-8

Dado /^que estou na pagina inicial$/ do
	visit "/"
end

Dado /^preencho o campo "([^"]*)" com "([^"]*)"$/ do |field, value|
	fill_in(field, :with => value)
end

Dado /^aperto o botao "([^"]*)"$/ do |button|
	click_button(button)
end

Entao /^eu deveria ver "([^"]*)"$/ do |text|
	page.should have_content(text)
end

