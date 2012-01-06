#encoding: utf-8 

class Restaurant < ActiveRecord::Base
	validates_presence_of :name, :message => "Must be completed"
	validates_presence_of :address, :message => "Must be completed"
	validates_presence_of :specialty, :message => "Must be completed"

	validates_uniqueness_of :name, :message => "Name already registered"

	validate :the_first_letter_should_be_capitalized

	private 
	def the_first_letter_should_be_capitalized
		errors.add("name", "The first letter should be capitalized")
	end
end
