#encoding: utf-8 

class Restaurant < ActiveRecord::Base
	has_many :qualifications	
	has_and_belongs_to_many :dishes
	has_attached_file :photo, :styles => { :medium => "300x300>", 
	                                       :thumb => "100x100>",
	                                       :large => "800x600>" }

	validates_presence_of :name, :message => "Must be completed"
	validates_presence_of :address, :message => "Must be completed"
	validates_presence_of :specialty, :message => "Must be completed"

	validates_uniqueness_of :name, :message => "Name already registered"

	validate :the_first_letter_should_be_capitalized

	has_many :comments, :as => :commentable

	def self.per_page
		10
	end

	private 
	def the_first_letter_should_be_capitalized
		errors.add("name", "The first letter should be capitalized") unless name =~ /[A-Z].*/
	end
end
