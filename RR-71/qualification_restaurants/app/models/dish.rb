class Dish < ActiveRecord::Base
	has_and_belongs_to_many :restaurants
	has_one :recipe	

	validates_presence_of :name, :message => "must be completed"
	validates_uniqueness_of :name, :message => " - name already registered"

	validate :validate_presence_of_more_than_one_restaurant

	private
	def validate_presence_of_more_than_one_restaurant
		errors.add("restaurants", "must exist at least one") if restaurants.empty?
	end
end
