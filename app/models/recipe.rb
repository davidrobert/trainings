class Recipe < ActiveRecord::Base
	has_one :dish
	validates_presence_of :content, :message => " - must be completed"

	validates_presence_of :dish_id
  validates_associated :dish
end
