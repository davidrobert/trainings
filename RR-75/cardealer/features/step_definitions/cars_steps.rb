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

Dado /^que os seguintes usuarios existem:$/ do |table|
	table.hashes.each do |hash|
		hash.merge! ({:password_confirmation => hash[:password]})
		User.create! hash
	end
end

Dado /^clico no link "([^"]*)"$/ do |arg1|
	click_link(arg1)
end

E /^estou logado como "([^\"])"$/ do |email|
	User.create! :email => 'jose@email.com', :password => '123456', :password_confirmation => '123456'
	click_link('Login')
	fill_in('user[email]', :with => 'jose@email.com')
	fill_in('user[password]', :with => '123456')
	click_button 'Sign in'
end
